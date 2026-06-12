package com.concurrency.problems.config.cache;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ConfigManager {
    private Map<String, String> config ;
    private ReadWriteLock readWriteLock ;

    public ConfigManager() {
        this.config = new HashMap<>() ;
        this.readWriteLock = new ReentrantReadWriteLock() ;
    }

    public String getConfig(String key) {
        if(key == null)
            return null ;
        Lock readLock = readWriteLock.readLock() ;
        try {
            readLock.lock();
            Thread.sleep(Duration.ofMillis(100));
            return config.get(key);
        } catch(Exception e) {
            return null ;
        } finally {
            readLock.unlock();
        }
    }

    public void updateConfig(String key, String value) {
        if(key == null || value == null)
            return ;

        Lock writeLock = readWriteLock.writeLock() ;
        try {
            writeLock.lock();
            this.config.put(key, value) ;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            writeLock.unlock();
        }
        return ;
    }
}
