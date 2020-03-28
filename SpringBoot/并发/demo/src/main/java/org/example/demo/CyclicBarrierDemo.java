package org.example.demo;

import java.util.concurrent.*;

/**
 * Create by Chen on 2020/3/27
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0;i < 3; i++){
            executorService.submit(() -> {
                echoMsg();
                try {
                    cb.await();//-1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        cb.await();
        System.out.println("你想怎么滴");
        executorService.shutdown();
    }

    private static void echoMsg() {
        System.out.println(Thread.currentThread().getName());
    }
}
