package org.example.demo;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: StreamDemo
 * @Description:
 * @Author: Chen
 * @Date: 2020/4/2 19:22
 * @Version: 1.0
 */
public class StreamDemo {

    public static void main(String[] args) {
        //stream 在性能方面不如for循环 但是 增加了代码的可读性 提高相应的开发效率
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        list.forEach(System.out::println);
//        list.stream().forEach();
//        list.parallelStream();
    }
}