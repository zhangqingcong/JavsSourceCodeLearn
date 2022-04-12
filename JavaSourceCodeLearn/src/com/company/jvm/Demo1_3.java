package com.company.jvm;
class A{};
class B{};
public class Demo1_3 {
    static A a = new A();
    static B b= new B();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(b){
                System.out.println("本thread获得了a 和 b");
            }
        }).start();

        Thread.sleep(1000);
        new Thread(()->{
            synchronized (b){
                synchronized (a){
                    System.out.println("我获得了 a 和 b");
                }
            }
        }).start();
    }
}
