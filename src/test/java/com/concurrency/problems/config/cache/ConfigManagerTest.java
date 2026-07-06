package com.concurrency.problems.config.cache;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ConfigManagerTest {
    public static final int TOTAL_THREADS = Runtime.getRuntime().availableProcessors();

    @Test
    public void testReadLockLatency() {
        Long startTime = System.nanoTime() ;
        try (ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS)) {

            ConfigManager configManager = new ConfigManager();

            configManager.updateConfig("k1", "v1");

            Runnable readRunnable = () -> {
                String value = configManager.getConfig("k1");
                System.out.printf("value from config : %s%n", value);
            };

            for (int i = 0; i < 10; ++i)
                executorService.submit(readRunnable);

            executorService.shutdown();
            try {
                executorService.awaitTermination(1, TimeUnit.MINUTES);
                Long endTime = System.nanoTime();
                Long timeTaken = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

                System.out.printf("Time taken: %d ms%n", timeTaken);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}