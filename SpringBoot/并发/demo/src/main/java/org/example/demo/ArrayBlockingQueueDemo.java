package org.example.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;

/**
 * @ClassName: ArrayBlockingQueueDemo
 * @Description:
 * @Author: Chen
 * @Date: 2020/4/1 19:41
 * @Version: 1.0
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {

        //ArrayBlockingQueue 是一个有限队列   BlockingQueue添加操作 put(会阻塞) 多余 offer(直接丢掉)
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
//        testOfferMethod(blockingQueue);
//        testAddMethod(blockingQueue);
        testPutMethod(blockingQueue);
        System.out.println(blockingQueue);
    }

    private static void testPutMethod(ArrayBlockingQueue<Integer> blockingQueue) throws InterruptedException {
        // 队列满了 会阻塞
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);
        blockingQueue.put(4);
    }


    private static void testOfferMethod(ArrayBlockingQueue<Integer> blockingQueue) {
        //添加  队列满了 则抛弃
        blockingQueue.offer(1);
        blockingQueue.offer(2);
        blockingQueue.offer(3);
        blockingQueue.offer(4);
    }

    private static void testAddMethod(ArrayBlockingQueue<Integer> blockingQueue) {
        //超出容量 抛出异常
        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
        blockingQueue.add(4);
    }



}