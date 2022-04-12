package com.atguigu.com;

public class Test02 {
    public static void main(String[] args) {
        Object o = new Object();
        /**
         * 0: new      new操作会确定所需要的空间大小 并进行0值操作     #2                  // class java/lang/Object
         * 3: dup  在操作数栈中会复制两份 生成一份当前变量的引用用来做赋值操作--位于栈底，还会在复制一份引用用来操作句柄
         * 就会有两个引用指向堆空间中的实体
         * 4: invokespecial #1      这里进行赋值操作 也称为显式赋值            // Method java/lang/Object."<init>":()V
         * 7: astore_1  这个操作是把局部变量从操作数栈中取出来 放到局部变量表中
         */
    }
}
