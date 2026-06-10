package com.concurrency.problems.ticket.dispenser;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairTicketDispenser implements TicketDispenser {
    public Lock lock = new ReentrantLock(true);
    private int count = 10_000;

    public Boolean purchaseTicket(String user) {
        if(count == 0)
            return false ;
        try {
            lock.lock() ;
            --count ;
            return true ;
        } finally {
            lock.unlock();
        }
    }
}
