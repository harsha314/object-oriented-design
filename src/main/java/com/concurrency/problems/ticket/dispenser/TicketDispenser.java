package com.concurrency.problems.ticket.dispenser;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface TicketDispenser {
    Boolean purchaseTicket(String user);
}
