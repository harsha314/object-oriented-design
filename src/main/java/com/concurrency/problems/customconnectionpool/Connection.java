package com.concurrency.problems.customconnectionpool;

public class Connection implements AutoCloseable {
     @Override
    public void close() throws Exception {
        System.out.println("closing connection");
    }
}
