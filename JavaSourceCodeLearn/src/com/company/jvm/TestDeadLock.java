package com.company.jvm;

public class TestDeadLock {

    private static Object obj1 = new Object();

    private static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run() {
            synchronized (obj1) {
                System.out.println("thread1 拿到了obj1 的锁");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj2) {
                    System.out.println("thread1 拿到了 obj2 的锁");
                }
            }
        }
    }

    private static class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (obj2) {
                System.out.println("thread2 拿到了obj2 的锁");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("thread2 拿到了 obj1 的锁");
                }
            }
        }
    }
}
