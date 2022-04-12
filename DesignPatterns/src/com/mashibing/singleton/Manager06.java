package com.mashibing.singleton;

public class Manager06 {
    //指令重排
    private static volatile Manager06 INSTANCE;

    private Manager06(){}

    public static Manager06 getInstance(){
        //双重检查 最外面这个检查 也有必要 如果不为空 就不用走加锁逻辑了
        if (INSTANCE == null){
            synchronized(Manager06.class){
                if (INSTANCE == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Manager06();
                }
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Manager06.getInstance().hashCode());
            }).start();
        }
    }
}
