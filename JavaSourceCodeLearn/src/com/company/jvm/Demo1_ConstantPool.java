package com.company.jvm;
//StringTable [] hashtable 结构不能扩容
public class Demo1_ConstantPool {
    /**
     * 常量池中的信息，都会被加载到运行时常量池中 这时a b ab 都是常量池中的符号 还没有变为Java 字符串对象
     * ldc #2 会把a 符号变为 "a" 字符串对象
     * ldc #3 会把 b 符号变为 "b" 字符串对象
     * ldc #4 会把 ab 符号变为 "ab" 字符串对象
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2; //new StringBuilder().append("a").append("b").toString() 创建了两个对象
        String s5 = "a" +"b"; //javac 在编译期间的优化，结果已经在编译期确定为ab
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        System.out.println(s3 == s5);
    }
}
