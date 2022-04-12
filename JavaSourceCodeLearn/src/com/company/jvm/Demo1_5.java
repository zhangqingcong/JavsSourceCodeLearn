package com.company.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示堆内存溢出 java.lang.OutOfMemoryError: Java heap space
 * OutOfMemoryError 是堆溢出
 * StackOverflow 是栈溢出
 * -Xmx8m
 */
public class Demo1_5 {
    public static void main(String[] args) {
        int i = 0;
        try {
            //使用new关键字创建出来的都放在堆中
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
