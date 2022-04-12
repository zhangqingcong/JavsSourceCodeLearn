package com.mashibing.singleton;

/**
 * 完美解决线程同步 还可以防止反序列化
 * 枚举类没有构造方法 就算拿到class文件 你也没有办法构造对象
 * 枚举类没有构造方法是Java语法规定的
 * 序列化：就是将对象转化成字节序列的过程
 * 反序列化：就是讲字节序列转化成对象的过程。
 */
public enum Manager08 {
    INSTANCE;

    public void m(){}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Manager08.INSTANCE.hashCode());
            }).start();
        }
    }
}
