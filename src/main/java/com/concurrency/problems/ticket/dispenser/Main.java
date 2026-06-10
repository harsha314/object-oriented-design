package com.concurrency.problems.ticket.dispenser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static int TOTAL_THREADS = 1000 ;

    public static void main(String[] args) {
        fairLockTest();
        unfairLockTest();
    }

    public static void fairLockTest() {
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
        
        Long endTime = System.currentTimeMillis() ;
        System.out.println("time taken : " + (endTime - startTime) + "ms");
    }

    public static void unfairLockTest() {
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
        
        Long endTime = System.currentTimeMillis() ;
        System.out.println("time taken : " + (endTime - startTime) + "ms");
    }
}
