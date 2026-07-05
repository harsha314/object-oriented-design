package com.concurrency.problems.executor.service;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        unbounded();
        Long endTime = System.currentTimeMillis();
        System.out.println("unbounded Total execution time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        bounded();
        endTime = System.currentTimeMillis();
        System.out.println("bounded Total execution time: " + (endTime - startTime));
    }

    public static void unbounded() {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        try (ExecutorService executorService = Executors.newFixedThreadPool(corePoolSize)) {
            for(int i = 0; i < corePoolSize * 2; i++) {
                executorService.execute(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}
                });
            }
        }

    }

    public static void bounded() {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = Runtime.getRuntime().availableProcessors();
        long keepAliveTime = 60;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        try(
        ExecutorService executorService = new ThreadPoolExecutor(
            corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue
        )) {
            for(int i = 0; i < corePoolSize * 2; i++) {
                executorService.execute(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}
                });
            }
        } catch (RejectedExecutionException ignored) {

        }
    }
}
