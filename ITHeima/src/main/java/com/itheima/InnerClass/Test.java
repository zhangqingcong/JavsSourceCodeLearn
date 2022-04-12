package com.itheima.InnerClass;

public class Test {
    public static void main(String[] args) {
        /**
         * 静态内部类创建对象的方法 重点在于静态 就像访问静态变量一样 用类名.访问
         */
        //外部类名.内部类名 对象名 = new 外部类名.内部类构造器
        StaticClass.Inner inner = new StaticClass.Inner();

    }
}
