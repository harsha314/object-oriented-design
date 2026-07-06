package com.concurrency.problems.executor.service;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
//        unbounded();
        Long endTime =    System.currentTimeMillis();
        System.out.println("unbounded Total execution time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        bounded(4);
        endTime = System.currentTimeMillis();
        System.out.println("bounded Total execution time: " + (endTime - startTime));
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

    public static ThreadPoolExecutor bounded(int workers) {
        // int corePoolSize = Runtime.getRuntime().availableProcessors();
        // int maximumPoolSize = Runtime.getRuntime().availableProcessors();
        long keepAliveTime = 2;
        // TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(workers);
        return new ThreadPoolExecutor(
                workers,
                workers,
                keepAliveTime,
                TimeUnit.SECONDS,
                workQueue,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
