package com.mashibing.singleton;

/**
 * lazy-loading
 * 懒汉式
 * 这种会有线程不安全的问题产生
 */
public class Manager03 {
    //这里不能用final修饰
    private static Manager03 INSTANCE;

    private Manager03() {
    }

    public static Manager03 getInstance() {
        if (INSTANCE == null) {//此处判断会有多线程异常 被切换了 另外一个线程进来了 就有可能会返回不同的实例
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Manager03();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                //同一个类的不同对象的hashcode是不同 不同类的实例也有可能相同
                System.out.println(Manager03.getInstance().hashCode());
            }).start();
        }
    }
}
