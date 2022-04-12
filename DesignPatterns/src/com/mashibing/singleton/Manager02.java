package com.mashibing.singleton;

/**
 * 这个类和Manager01本质一样 写法略有差异
 */
public class Manager02 {
    private static final Manager02 INSTANCE;

    static {
        INSTANCE = new Manager02();
    }

    private Manager02() {
    }

    public static Manager02 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Manager02 manager01 = Manager02.getInstance();
        Manager02 manager02 = Manager02.getInstance();
        System.out.println(manager01 == manager02);
    }
}
