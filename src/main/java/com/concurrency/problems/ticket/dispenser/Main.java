package com.concurrency.problems.ticket.dispenser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    static int TOTAL_THREADS = 1000 ;

    public static void main(String[] args) throws InterruptedException {
        fairLockTest();
        unfairLockTest();
    }

    public static void fairLockTest() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        TicketDispenser ticketDispenser = new FairTicketDispenser() ;
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS) ;
        Runnable runnable = () -> {
            for(int i = 0; i < 100; ++i) {
                ticketDispenser.purchaseTicket(Thread.currentThread().getName() + ":" + i) ;
            }
        } ;
        for(int i = 0; i < TOTAL_THREADS; ++i)
            executorService.submit(runnable) ;

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        
        Long endTime = System.currentTimeMillis() ;
        System.out.println("time taken : " + (endTime - startTime) + "ms");
        System.out.println("Tickets left : " + ticketDispenser.getRemainingTickets());
    }

    public static void unfairLockTest() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        TicketDispenser ticketDispenser = new UnfairTicketDispenser() ;
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS) ;
        Runnable runnable = () -> {
            for(int i = 0; i < 100; ++i) {
                ticketDispenser.purchaseTicket(null) ;
            }
        } ;
        for(int i = 0; i < TOTAL_THREADS; ++i)
            executorService.submit(runnable) ;

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        
        Long endTime = System.currentTimeMillis() ;
        System.out.println("time taken : " + (endTime - startTime) + "ms");
        System.out.println("Tickets left : " + ticketDispenser.getRemainingTickets());
    }
}
