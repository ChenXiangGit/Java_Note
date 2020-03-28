package org.example.demo;

import java.util.concurrent.*;

/**
 * Create by Chen on 2020/3/27
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0;i < 3; i++){
            executorService.submit(() -> {
                echoMsg();
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("你想怎么滴");
        executorService.shutdown();
    }

    private static void echoMsg() {
        System.out.println(Thread.currentThread().getName());
    }

}
