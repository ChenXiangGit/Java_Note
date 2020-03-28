package org.example.demo;

import java.util.concurrent.*;

/**
 * Create by Chen on 2020/3/27
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Semaphore semaphore = new Semaphore(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0;i < 3; i++){
            executorService.submit(() -> {
                echoMsg();
                try {
                    semaphore.acquire();//-1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        semaphore.release();
        System.out.println("你想怎么滴");
        executorService.shutdown();
    }

    private static void echoMsg() {
        System.out.println(Thread.currentThread().getName());
    }
}
