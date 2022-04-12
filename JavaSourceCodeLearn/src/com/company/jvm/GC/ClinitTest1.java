package com.company.jvm.GC;

public class ClinitTest1 {
    static class Father{
        public static int A = 1;
        static {
            A = 2;
        }
    }
    static class Son extends Father{
        public static int B = A;

    }

    public static void main(String[] args) {
        //先加载Father类 后加载Son类
        System.out.println(Son.B);
    }
}
