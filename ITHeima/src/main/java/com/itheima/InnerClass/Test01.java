package com.itheima.InnerClass;

public class Test01 {
    public static void main(String[] args) {
        //成员内部类 重点在于成员 访问成名不能通过类名.的方式 而要创建对象
        Outer01.Inner01 inner01 = new Outer01().new Inner01();

        inner01.setName("内部");
        inner01.show();
//        Outer01.Inner01.test(); 这个要JDK16才可以了

        System.out.println("-----------------");
        Outer01.Inner01 inner011 = new Outer01("爱学习").new Inner01();
        inner011.show();
    }
}
