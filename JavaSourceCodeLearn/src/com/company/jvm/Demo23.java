package com.company.jvm;

public class Demo23 {
    //StringTable ["a","b","ab"]
    public static void main(String[] args) {
        /**
         * new String("a")动作把a放到字符串常量表里面 同时在堆中创建一个对象
         * new String("b") 动作把b放到字符串常量表里面 同时在堆中创建一个对象
         * new String("ab") s = new String("a") + new String("b") 等价与new String（"ab"）
         */
        String s = new String("a") + new String("b");//
        String s2 = s.intern();//将这个字符串对象尝试放入串池，如果有则并不会放入 若果没有则放入串池 会把串池中的对像返回
//        System.out.println(s2 == "ab"); //true
//        System.out.println(s == "ab"); //true
        test();

    }

    public static void test() {
        String x = "ab";//执行到这一步的时候 已经把 ab 放到StringTable中了
        //堆中 new出来的都在堆中 new String("a") new String("b") new String("ab")
        String S = new String("a") + new String("b");
        String s2 = S.intern();//将这个字符串对象尝试放入串池 如果串池中已经有了就不放入了 没有则放入 会把串池的对象放回 s2就不是堆内存中的对象了 而是串池对象
        System.out.println(s2 == x); //s2 不管放入不放入 返回的都是字符串常量池中的对象了 s2已经是字符串中变量了
        System.out.println(S == x);//S还是堆内存中的 X在字符串常量池中
    }
}
