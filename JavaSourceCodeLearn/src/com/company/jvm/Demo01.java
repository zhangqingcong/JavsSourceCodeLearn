package com.company.jvm;

/**
 * 局部变量的线程安全问题
 */
public class Demo01 {
    static void m1(){
        int x = 0;
        for (int i = 0; i < 5000; i++) {
            x++;
        }
        System.out.println(x);
    }
}
