package com.concurrency.problems.customconnectionpool;

import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleConnectionPool {

    private Lock lock ;
    private Condition connectionUnavailable ;
    private Set<Connection> connections ;

    public SimpleConnectionPool(Set<Connection> connections) {
        this.lock = new ReentrantLock(true);
        this.connectionUnavailable = lock.newCondition();
        this.connections = connections;
    }

    public Connection acquire() {
        lock.lock() ;
        try {
            if(connections.size() == 0) {
                connectionUnavailable.await();
            }
            Connection connection = connections.iterator().next();
            connections.remove(connection) ;
            return connection ;
        } catch (Exception e) {
            // TODO: handle exception
            return null ;
        } finally {
            lock.unlock();
        }
    }

    public void release(Connection c) {
        lock.lock();
        try {
            connections.add(c) ;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }
}
