package com.concurrency.problems.executor.service;

import java.util.concurrent.*;

public class CustomExecutorService {
    public static void main(String[] args) {
//        Long startTime = System.currentTimeMillis();
////        unbounded();
//        Long endTime =    System.currentTimeMillis();
//        System.out.println("unbounded Total execution time: " + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        bounded(4, );
//        endTime = System.currentTimeMillis();
//        System.out.println("bounded Total execution time: " + (endTime - startTime));
    }

//    public static ThreadPoolExecutor unbounded() {
//        int corePoolSize = Runtime.getRuntime().availableProcessors();
//        try (ThreadPoolExecutor executorService = Executors.newFixedThreadPool(corePoolSize)) {
//            for(int i = 0; i < corePoolSize * 2; i++) {
//                return executorService;
//            }
//        }
//
//    }

    public static ThreadPoolExecutor bounded(int corePoolSize, int maximumPoolSize, int keepAliveTimeInSeconds, int queueCapacity) {
        maximumPoolSize = Math.min(maximumPoolSize, Runtime.getRuntime().availableProcessors());
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(queueCapacity);
        return new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTimeInSeconds,
                TimeUnit.SECONDS,
                workQueue,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
