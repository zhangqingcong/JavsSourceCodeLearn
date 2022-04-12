package com.itheima.InnerClass;

/**
 * 局部内部类
 * 在局部中的类
 * 如在方法 在代码块 构造器这些局部当中
 */
public class TestPartInnerClass {
    static {
        class Dog{
        }
        abstract class Animal {
        }
//        interface SportManInetr{}
    }

    public static void main(String[] args) {
        class Cat{
            private String name;
//            public static int onLineNumber = 100;
            public String getName(){
                return name;
            }
        }
    }
}
