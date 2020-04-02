package org.example.demo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: LinkedBlockingCurrentQueue
 * @Description:
 * @Author: Chen
 * @Date: 2020/4/2 14:06
 * @Version: 1.0
 */
public class LinkedBlockingCurrentQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (AtomicInteger i = new AtomicInteger(1); i.get() < 100; i.incrementAndGet()) {
            executorService.submit(()->{
                try {
                    blockingQueue.put(i.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executorService.submit(()->{
                try {
                    System.out.println( blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }



        executorService.shutdown();

    }
}