package com.company.jvm.GC;

public class InitTest {
    private static final String a = "a";
    private static final String b = "b";

    public InitTest(){

    }
    static {
        System.out.println("初始化");
    }

}
