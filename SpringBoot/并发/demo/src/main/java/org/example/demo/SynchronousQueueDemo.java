package org.example.demo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: SynchronousQueueDemo
 * @Description:
 * @Author: Chen
 * @Date: 2020/4/2 14:10
 * @Version: 1.0
 */
public class SynchronousQueueDemo {

    //SynchronousQueue 互斥的使用场景
    //SynchronousQueue put()之后，必须被其他线程take()
    //SynchronousQueue capacity == 0 ,但是允许put()一条数据
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue = new SynchronousQueue<>();
//        queue.add(1);
//        queue.put(1);
//        System.out.println(queue.size());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (AtomicInteger i = new AtomicInteger(1); i.get() < 100; i.incrementAndGet()) {
            executorService.submit(()->{
                try {
                    //只可以使用put(),不可以使用offer(),最好不要使用add
                    System.out.println(i.get());
                    queue.put(i.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
//            executorService.submit(()->{
//                try {
//                    System.out.println(queue.take());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
        }

        executorService.awaitTermination(10, TimeUnit.MILLISECONDS);
        executorService.shutdown();
    }

}