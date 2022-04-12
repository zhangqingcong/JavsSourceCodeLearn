package com.mashibing.singleton;

/**
 * 单例模式 一个类在内容中只有一个单个实例的模式
 * 饿汉式是指：类加载到内存后，就立即实例化一个单例，
 * JVM保证线程安全 每个类JVM只会load到内存一次 所以也就只会实例一个
 * 简单实用，推荐使用饿汉式 缺点就是就算不用这个对象 也要在类装载时就完成实例
 * 这个类是懒汉式的
 */
public class Manager01 {
    //常量 类加载的时候会给赋值
    private static final Manager01 INSTANCE = new Manager01();

    /**
     * 构造方法写出来JVM就不会给类弄个默认的构造方法了 切访问修饰符是private修饰的
     * 达到无法通过new Manager01()的方式创建新的实例
     */
    private Manager01() {
    }

    ;

    /**
     * 只能通过调用getInstance()方法来获得实例
     *
     * @return
     */
    public static Manager01 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("也可以写其他的业务逻辑");
    }

    /**
     * 验证一下是不是只有一个实例
     * @param args
     */
    public static void main(String[] args) {
        Manager01 instance1 = Manager01.getInstance();
        Manager01 instance2 = Manager01.getInstance();
        System.out.println(instance1==instance2);
    }
}
