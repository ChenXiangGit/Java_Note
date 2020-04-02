package org.example.demo;

import java.util.concurrent.*;

/**
 * @ClassName: FutureTaskDemo
 * @Description:
 * @Author: Chen
 * @Date: 2020/3/30 10:25
 * @Version: 1.0
 */
public class FutureTaskDemo {

    //阻塞式结果返回
    // 无法链式多个Future
    // 无法合并多个Future结果
    // 缺少异常处理
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<String> ft1 = new FutureTask<>(() -> {
            System.out.println("啦啦啦");
//            Thread.sleep(2000);
//            return "1";
        },"987");//指定返回结果，线程任务执行成功，返回987
        FutureTask<String> ft2 = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return "2";
        });
        FutureTask<String> ft3 = new FutureTask<>(() -> "3");

        executorService.submit(ft1);
        executorService.submit(ft2);
        executorService.submit(ft3);

        System.out.println( ft1.get());
        System.out.println( ft2.get());
        System.out.println( ft3.get());

        executorService.shutdown();
        System.out.println("shut down");
    }
}