package com.concurrency.problems.executor.service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

class BoundedExecutorServiceTest {
    @Test
    void testBoundedQueue() throws Exception {
        int workers = 4;
//        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(workers);
        try (ThreadPoolExecutor pool = CustomExecutorService.bounded(workers)) {
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
            assertTrue(allWorkersBusy.await(2, SECONDS));         // deterministic: workers are pinned

            // Now flood. If the queue were bounded, this would block or reject.
            int flood = 10;
            for (int i = 0; i < flood; i++) pool.submit(() -> null);

            // The proof: all 100k sit in the queue, none rejected, none run.
            assertEquals(flood, pool.getQueue().size());
            assertEquals(workers, pool.getPoolSize());            // still only 4 threads

            block.countDown();
            pool.shutdown();
            assertTrue(pool.awaitTermination(5, SECONDS));
        }
    }
}