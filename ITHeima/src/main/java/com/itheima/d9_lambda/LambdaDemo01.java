package com.itheima.d9_lambda;

/**
 * Lambda是用来简化匿名内部类的代码写法
 * Lambda表达式的简化格式
 *      (匿名内部类被重写方法的形参列表)->{
 *          被重写方法的方法体代码
 *  }
 *  -> 是语法形式 无实际含义
 *  Lambda表达式只能简化函数式接口的匿名内部类的写法形式
 *  不是所有的匿名内部类都可以用lambda来简写
 *  函数式接口
 *  1、是一个接口，且接口中有且仅有一个抽象方法
 *  2、通常会在接口上用一个@FunctionalInterface注解，标记该接口必须是函数式接口
 */
public class LambdaDemo01 {

    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void run() {
                System.out.println("");
            }
        };
        animal.run();
    }

//    Animal animal1 =()->{
//        System.out.println("");
//    }

}

abstract  class Animal{
        public abstract void run();
    }


