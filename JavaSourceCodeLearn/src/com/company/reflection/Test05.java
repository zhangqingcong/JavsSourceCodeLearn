package com.company.reflection;

import javax.crypto.spec.PSource;

public class Test05 {
    public static void main(String[] args) {
         A a = new A();
        System.out.println(A.m);
    }
}
class A{

    static {
        System.out.println("A类的静态代码块初始化");
         m=300;
    }
    static int m = 100;

    public A(){
        System.out.println("A类的无参构造器初始化了");
    }
}
