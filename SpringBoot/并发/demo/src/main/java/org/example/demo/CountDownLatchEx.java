package org.example.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CountDownLatchEx
 * @Description: CountDownLatchEx 中文意思 倒计时 主要用来解决一个线程等待多个线程的场景
 * @Author: Chen
 * @Date: 2020/3/28 15:27
 * @Version: 1.0
 */
public class CountDownLatchEx {
    public static void main(String[] args) throws InterruptedException{
        // 创建 2 个线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // 计数器初始化为 2
        CountDownLatch latch = new CountDownLatch(2);
        executor.execute(()-> {
            System.out.println("T1");
            latch.countDown();
        });
        executor.execute(()-> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2");
            latch.countDown();
        });
        // 等待两个查询操作结束
        latch.await();
        System.out.println("打死你个龟孙。。。。。");
    }
}