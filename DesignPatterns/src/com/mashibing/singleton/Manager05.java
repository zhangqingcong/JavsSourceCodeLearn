package com.mashibing.singleton;

public class Manager05 {
    private static Manager05 INSTANCE;
    private Manager05(){}

    public static Manager05 getInstance(){
        if (INSTANCE == null ){
            /**
             * 尝试通过减小同步代码的方式提高效率 但这样不行
             * 线程1已经执行过判断语句了 就被切换到了线程2
             * 线程2有可能执行完毕 返回一个实例 然后切换到了
             * 线程1 已经执行过判断语句了 执行执行走到里面的
             * 也返回了一个实例 这就返回了两个不同的实例
             */
            synchronized (Manager05.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Manager05();
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
                System.out.println(Manager05.getInstance().hashCode());
            }).start();
        }
    }
}
