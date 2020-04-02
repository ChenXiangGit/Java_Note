package org.example.demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.concurrent.locks.StampedLock;

/**
 * Create by Chen on 2020/3/27
 */
public class StampLockDemo {


    public static void main(String[] args) {
        //大量读 少量写
//        StampedLock stampedLock = new StampedLock();
//        MethodHandles.Lookup lookup = MethodHandles.lookup();
        BigDecimal b1 = BigDecimal.valueOf(12.00);
        System.out.println(b1.setScale(0));
    }
}
