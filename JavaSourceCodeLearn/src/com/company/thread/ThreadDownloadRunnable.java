package com.company.thread;
//创建线程的方式2 实现runnable接口，重写run()方法，
public class ThreadDownloadRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("多线程在看代码");
        }
    }

    public static void main(String[] args){
        ThreadDownloadRunnable t = new ThreadDownloadRunnable();
//        Thread thread = new Thread(t);
//        thread.start();
        new Thread(t).start();
        
        for (int i = 0; i < 100; i++) {
            System.out.println("main线程学习多线程");
        }
    }
}
