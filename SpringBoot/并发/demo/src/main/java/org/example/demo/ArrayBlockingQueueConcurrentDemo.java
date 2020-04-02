package org.example.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ArrayBlockingQueueConcurrentDemo
 * @Description:
 * @Author: Chen
 * @Date: 2020/4/2 13:47
 * @Version: 1.0
 */
public class ArrayBlockingQueueConcurrentDemo {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->{
            try {
                blockingQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(()->{
            try {
                blockingQueue.put(2);
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


        executorService.shutdown();

    }
}