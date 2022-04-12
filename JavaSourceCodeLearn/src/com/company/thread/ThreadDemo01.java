package com.company.thread;
//创建线程方式一，类继承Thread类，重写run方法，调用start方法 不调用run方法使用为调用start方法才是开启新线程，run方法还是在主线程里面顺序执行
public class ThreadDemo01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程类运行了"+i);

        }
    }

    public static void main(String[] args) throws Exception{
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        //调用线程对象的start()方法启动该线程，不调用的话这个线程不启动，启动以后也不一定立即执行 要等CPU调度
        threadDemo01.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("main线程运行了"+i);
        }


    }
}
