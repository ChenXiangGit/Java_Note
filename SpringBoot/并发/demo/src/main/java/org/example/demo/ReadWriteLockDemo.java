package org.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: ReadWriteLock
 * @Description:
 *  * 读写锁实现缓存
 *  * ReentrantReadWriteLock 只支持锁的降级 不支持锁升级 并且只有写锁可以创建条件变量
 *  * 读写锁允许多个线程同时读共享变量，当一个线程在写共享变量的时候，是不允许其他线程执行写操作和读操作。
 * @Author: Chen
 * @Date: 2020/3/28 14:27
 * @Version: 1.0
 */
public class ReadWriteLockDemo<K,V> {

    private final Map<K,V> map = new HashMap<>();
    private final ReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock readLock = rwl.readLock();
    private final Lock writeLock = rwl.writeLock();

    public static void main(String[] args) {
        ReadWriteLockDemo<String, String> demo = new ReadWriteLockDemo<>();
        new Thread(()->{
            try {
                demo.get1("1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                demo.get1("2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                demo.put("1","2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    V put(K key, V v) throws InterruptedException {
        writeLock.lock();
        try {
            System.out.printf("k:%s,v:%s \n",key,v);
            Thread.sleep(10*1000);
            return map.put(key, v);
        } finally {
            writeLock.unlock();
        }
    }

    V get1(K key) throws InterruptedException {
        Thread.sleep(1000);
        readLock.lock();
        try {
            System.out.printf("k:%s\n",key);
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 按需加载
     * @param key key
     * @return v
     */
    V get2(K key) {
        V v = null;
        // 读缓存
        readLock.lock();
        try {
            v = map.get(key);
        } finally{
            readLock.unlock();
        }
        // 缓存中存在，返回
        if(v != null) {
            return v;
        }
        // 缓存中不存在，查询数据库
        writeLock.lock();
        try {
            // 再次验证
            // 并发情况下其他线程可能已经查询过数据库
            v = map.get(key);
            if(v == null){
                // 查询数据库
                map.put(key, v);
            }
        } finally{
            writeLock.unlock();
        }
        return v;
    }

}