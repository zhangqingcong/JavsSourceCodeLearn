package com.itheima.base;

/**
 * 字面量 数据在程序中的书写格式
 * 计算机是用来处理数据的，字面量就是告诉程序员：数据在程序中的书写格式
 */
public class LiteralDemo {
    public static void main(String[] args) {
    //1、整数
        System.out.println(666);
        //2、小数
        System.out.println(9.9);
        //3、字符 用单引号包起来 有且只能有一个字符
        System.out.println('a');
        System.out.println('1');
        System.out.println('中');
//        System.out.println('ab');
//        System.out.println('12');
//        System.out.println('中国');//Too many characters in character literal
        System.out.println(' '); //空字符 有且只能有一个
//        System.out.println('');//Empty character literal 这种写法也是错的
        //特殊的字符 \n 换行  \t 制表符
        System.out.println('\n');
        System.out.println('\t');

        //4、字符串 必须使用双引号引起来 里面的内容其实可以随意
        System.out.println("你好 中国");
        System.out.println("");
        System.out.println("  ");
        System.out.println("a");
        System.out.println("你");

        //5、布尔值 只有两个true false
        System.out.println(true);
        System.out.println(false);

    }
}
