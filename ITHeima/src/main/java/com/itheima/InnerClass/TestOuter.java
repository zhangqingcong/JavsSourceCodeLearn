package com.itheima.InnerClass;

public class TestOuter {
    public static void main(String[] args) {
        //ch
        Outer.Inner inner = new Outer.Inner();
        inner.setName("张三");
        inner.show();
    }
}
