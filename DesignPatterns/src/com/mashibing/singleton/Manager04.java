package com.mashibing.singleton;

/**
 * 解决lazy-loading线程不安全的问题
 */
public class Manager04 {
    private static Manager04 INSTANCE;

    private Manager04() {
    }

    //加锁解决线程不安全的问题 不过降低了效率
    public static synchronized Manager04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Manager04();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Manager04.getInstance().hashCode());
            }).start();
        }
    }
}
