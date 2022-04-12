package com.company.jvm;

/**
 * 验证堆内存大小
 */
public class HeapGC {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("1...");
        Thread.sleep(30000);

        byte[] array = new byte[1024*1024*10];// 10Mb
        System.out.println("2...");
        Thread.sleep(3000);

        array = null;
        System.gc();
        System.out.println("3...");
        Thread.sleep(1000000L);
    }
}
