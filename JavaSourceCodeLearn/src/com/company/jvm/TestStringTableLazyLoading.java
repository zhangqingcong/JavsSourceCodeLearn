package com.company.jvm;

/**
 * 演示字符串字面量也是延迟成为对象的
 */
public class TestStringTableLazyLoading {
    public static void main(String[] args) {
        int x = args.length;
        System.out.println(); //总共是1264个

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("0");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("0");
    }
}
