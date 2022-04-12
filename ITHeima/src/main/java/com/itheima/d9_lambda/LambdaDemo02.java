package com.itheima.d9_lambda;

public class LambdaDemo02 {
    public static void main(String[] args) {
//        Swimming s = new Swimming() {
//            @Override
//            public void swim() {
//                System.out.println("老师游泳贼溜～～～～～～～");
//            }
//        };
//        Swimming s = () ->{
//            System.out.println("老师游泳贼溜～～～～～～～");
//        };
        Swimming s = () -> System.out.println();

        s.swim();

        System.out.println("----------------------");
        go(()->{
            System.out.println("学生游泳很开心。。。。。。");
        });
    }

    public static void go(Swimming s){
        System.out.println("开始。。。");
        s.swim();
        System.out.println("结束。。。");
    }
}

@FunctionalInterface
interface Swimming{
    void swim();
}