package com.concurrency.problems.customconnectionpool;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        
    }

    public static void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Set<Connection> connections = new HashSet<>();

        for(int i = 0; i < 5; ++i) connections.add(new Connection());

        SimpleConnectionPool simpleConnectionPool = new SimpleConnectionPool(connections);

        Runnable runnable = () -> {
            try {
                Connection connection = simpleConnectionPool.acquire();
                System.out.println("");
                Thread.sleep(Duration.ofMillis(50));
                simpleConnectionPool.release(connection);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };
    
        for(int i = 0; i < 15; ++i) {
            executorService.submit(runnable);
        }

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES) ;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
