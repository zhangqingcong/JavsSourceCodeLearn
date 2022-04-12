package com.mashibing.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Manager07 {

    private Manager07(){}

    private static class Manager07Holder{
        private final static Manager07 INSTANCE = new Manager07();
    }
    public static Manager07 getInstance(){
        return Manager07Holder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Manager07.getInstance().hashCode());
            }).start();
        }
    }
}
