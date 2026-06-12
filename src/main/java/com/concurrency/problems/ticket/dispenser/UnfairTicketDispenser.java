package com.concurrency.problems.ticket.dispenser;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairTicketDispenser implements TicketDispenser {
    public Lock lock = new ReentrantLock(true);
    private int count = 10_000;

    public Boolean purchaseTicket(String user) {
        lock.lock() ;
        
        try {
            if(count == 0)
                return false ;
            --count ;
            return true ;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long getRemainingTickets() {
        return this.count ;
    }
}
