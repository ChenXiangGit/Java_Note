package org.example.demo;

/**
 * @ClassName:StampedLockDemo
 * @Description:
 *  * 描述:
 *  * StampedLockEx
 *  * 写锁和悲观锁 跟ReentrantReadWriteLock 类似，非可重入锁，并且不支持条件变量
 *  * ReadWriteLock 支持多个线程同时读，但是当多个线个线程同时读的时候，
 *  * 所有的写操作会被阻塞；而 StampedLock 提供的乐观读（无锁），是允许一个线程获取写锁的，也就是说不是所有的写操作都被阻塞。
 *  * 不能直接使用interrupt 会导致cpu100%
 *  * 若想中断可以使用
 *  * readLockInterruptibly() 和writeLockInterruptibly()
 *  *
 * @Author:Chen
 * @Date:2020/3/28 14:53
 * @Version:1.0
 */
public class StampedLockDemo {



}