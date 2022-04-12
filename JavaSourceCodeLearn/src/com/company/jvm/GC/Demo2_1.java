package com.company.jvm.GC;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20M -Xmx20M -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
 */
public class Demo2_1 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;
//    private final static int _16MB = ;  类加载过程中 在loading阶段的preparation阶段不会为final修饰的static分配内存并设置默认值
    //应为这个属于常量 要在编译阶段就赋值
    /**
     * 类变量会在loading阶段的preparation阶段分配内存并设置默认值
     */
    private static int a;
    private int b;

    public int d= 9;

    public static void main(String[] args) throws InterruptedException {
         int c ;
         int e=1;
        List<byte[]> list = new ArrayList<>();
//        list.add(new byte[_7MB]);
//        list.add(new byte[_512KB]);
//        list.add(new byte[_512KB]);
       new Thread(()->{
           list.add(new byte[_8MB]);
           list.add(new byte[_8MB]);
       }).start();
        /**
         * 一个线程运行出错不会导致整个进程停止
         */
        System.out.println("sleep...");
        Thread.sleep(1000L);
    }
}
