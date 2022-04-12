package com.company.reflection;
//测试类什么时候初始化
public class Test06 {
    static {
        System.out.println("main类");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动调用
//        Son son = new Son();

        //反射也会产生主动引用
//        Class.forName("com.company.reflection.Son");
//        Class.forName("com.company.reflection.Son");

        //不会产生类的引用的方法
//        System.out.println(Son.b);
//        Son[] array = new Son[5];
//        System.out.println(Son.N);

//        System.out.println(Son.b);//父类被初始化了 但是子类本身并没有初始化 访问了父类中的元素
        System.out.println(Son.m);

    }
}
class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    int n = 9;
    static final int N = 1;
}
