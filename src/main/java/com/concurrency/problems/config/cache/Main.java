package com.concurrency.problems.config.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int TOTAL_THREADS = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {
        testReadLockLatency();
    }

    public static void testReadLockLatency() {
        Long startTime = System.nanoTime() ;
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS) ;
        
        ConfigManager configManager = new ConfigManager() ;

        configManager.updateConfig("k1", "v1");

        Runnable readRunnable = () -> {
            String value = configManager.getConfig("k1") ;
            System.out.println(String.format("value from config : %s", value));
        };

        for(int i = 0; i < 10; ++i)
            executorService.submit(readRunnable) ;

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
            Long endTime = System.nanoTime() ;
            Long timeTaken = TimeUnit.NANOSECONDS.toMillis(endTime - startTime) ;
            System.out.println(String.format("Time taken: %d ms", timeTaken));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
