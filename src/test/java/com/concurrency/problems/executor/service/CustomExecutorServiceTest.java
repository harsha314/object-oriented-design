package com.concurrency.problems.executor.service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

class CustomExecutorServiceTest {
    @Test
    void testBoundedQueue() throws Exception {
        int workers = 4, queueCapacity = 10;
        int maximumPoolSize = 10, keepAliveTimeInSeconds = 10;
        int flood = 1000;
        try (ThreadPoolExecutor pool = CustomExecutorService.bounded(workers,
                maximumPoolSize, keepAliveTimeInSeconds, flood)) {
            CountDownLatch block = new CountDownLatch(1);        // gate to pin workers
            CountDownLatch allWorkersBusy = new CountDownLatch(workers);

            // Occupy every worker thread so nothing drains the queue.
            for (int i = 0; i < workers; i++) {
                pool.submit(() -> {
                    allWorkersBusy.countDown();
                    block.await();                                // hold the thread
                    return null;
                });
            }
            assertTrue(allWorkersBusy.await(keepAliveTimeInSeconds, SECONDS));         // deterministic: workers are pinned

            // Now flood. If the queue were bounded, this would block or reject.

            for (int i = 0; i < flood; i++) pool.submit(() -> null);

            // The proof: all 100k sit in the queue, none rejected, none run.
            assertEquals(flood, pool.getQueue().size());
            assertEquals(workers, pool.getPoolSize());            // still only 4 threads

            block.countDown();
            pool.shutdown();
            assertTrue(pool.awaitTermination(5, SECONDS));
        }
    }

    @Test
    void boundedPool_rejectsWhenSaturated() throws Exception {
        int workers = 4, queueCap = 10;
        int maximumPoolSize = 10;
        int keepAliveTimeInSeconds = 1;
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(
//                workers, workers, 0L, MILLISECONDS,
//                new ArrayBlockingQueue<>(queueCap),
//                new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor pool = CustomExecutorService.bounded(workers,
                workers, keepAliveTimeInSeconds, queueCap);

        CountDownLatch block = new CountDownLatch(1);
        CountDownLatch busy = new CountDownLatch(workers);
        for (int i = 0; i < workers; i++)
            pool.submit(() -> {
                busy.countDown();
                block.await();
                return null;
            });
        assertTrue(busy.await(keepAliveTimeInSeconds, SECONDS));

        for (int i = 0; i < queueCap; i++) pool.submit(() -> null);   // fill queue exactly

        // workers(4) + queue(10) = 14 accepted; the 15th must be rejected.
        assertThrows(RejectedExecutionException.class, () -> pool.submit(() -> null));

        block.countDown();
        pool.shutdownNow();
    }
}