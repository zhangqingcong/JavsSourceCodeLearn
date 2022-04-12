package com.company.jvm;

/**
 * 演示栈内存溢出
 * 没有结束递归调用
 */
public class StackOverflowDemo {
    private static int count;

    public static void main(String[] args) {
        try{
            method1();
        } catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1(){
        count++;
        method1();
    }
}
