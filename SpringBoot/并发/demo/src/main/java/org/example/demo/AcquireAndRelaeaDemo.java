package org.example.demo;

/**
 * Create by Chen on 2020/3/26
 */
public class AcquireAndRelaeaDemo {

    public static void main(String[] args) {

        Thread thread = new Thread((() -> {

        }));
        thread.start();
        thread.interrupt();
        Thread.interrupted();
        Thread.interrupted();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
    }
}
