package org.example.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by Chen on 2020/3/26
 */
public class RetrantLockDemo {

    public static void main(String[] args) {
        lockOpsMethods();
    }

    private static void lockOpsMethods() {
        ReentrantLock lock = new ReentrantLock();
        int count = lock.getHoldCount();
        System.out.printf("在 lock() 方法调用之前的线程[%s]重进入数：%d\n", Thread.currentThread().getName(), count);
        lock(lock, 10);
    }

    private static void lock(ReentrantLock lock, int times) {
        if (times < 1) {
            return;
        }
        lock.lock();
        try {
            // times-- load, minus 1
            lock(lock, --times);
            System.out.printf("第%s次在 lock() 方法调用之后的线程[%s]重进入数：%d\n",
                    times + 1,
                    Thread.currentThread().getName(),
                    lock.getHoldCount());
        } finally {
            lock.unlock();
        }

    }

}
