package org.example.demo;

import com.sun.jdi.event.StepEvent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName: ConcurrentHashMapDemo
 * @Description:
 * @Author: Chen
 * @Date: 2020/4/2 15:44
 * @Version: 1.0
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        //ConcurrentHashMap 用于读多写少的场景
        //ConcurrentHashMap 1.6部分锁 -> 1.7 无锁 segment ->1.8 无锁 红黑树
        // ConcurrentHashMap 计算hashCode时，质数是最好的选择
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        //用于读多写多的场景，要在保证内存允许的情况下
        ConcurrentSkipListMap<String, String> skipListMap = new ConcurrentSkipListMap<>();
    }
}