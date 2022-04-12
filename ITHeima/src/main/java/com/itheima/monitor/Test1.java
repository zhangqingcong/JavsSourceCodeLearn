package com.itheima.monitor;


public class Test1 {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                count++;
            }
        },"t1");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                count--;
            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
