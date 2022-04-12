package com.company.jvm;

/**
 * 栈 是一种线性表
 *      是线程运行需要的内容空间
 * 栈帧是每个方法运行时需要的内存
 */
public class Stack {
    public static void main(String[] args) {
        method1();
    }
    public static void method1(){
        method2(1,2);
    }
    public static int method2(int a,int b){
        int c = a + b;
        return c;
    }
}
