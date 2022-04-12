package com.itheima.InnerClass;

public class Outer01 {
    public static int num =111;
    private String hobby;
    public Outer01(){}
    public Outer01(String hobby){
        this.hobby = hobby;
    }

    /**
     * 成员内部类 顾名思义 是外部类的一个成员 没有static修饰 属于外部类对象的
     */
    public class Inner01{
        private String name;
        private int age;
//        public static int a = 100; JDK 16以后才支持静态成员

//        public static void test(){
//            System.out.println(1);
//        }

        public void show(){
            System.out.println("名称："+name);
            System.out.println("数量："+num);
            System.out.println("爱好："+hobby);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
