package com.company.jvm;

public class Demo1_21_StringTable {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";//两个常量拼接 放到StringTable中
        String s4 = s1 + s2;//两个变量拼接  通过new String("ab") 在堆中的对象
        String s5 = "ab"; //字面量
        String s6 = s4.intern();//尝试把s4 ab 放到常量池中 此时常量池中已经有ab 常量了 放入失败 但是返回的是常量池中数据

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);

        String x2 = new String("c")+new String("d");//堆中
//        String x1 = "cd";//常量池
//        x2.intern();//尝试把x2放到常量池中 但是常量池已经有 cd了 放失败了 x2还在堆中
//        String x3 = x2.intern();
//        System.out.println(x1 == x2);//
//        System.out.println(x1 == x3);
//        x2.intern();//x2把变量存到常量池中
//        String x1 = "cd";//常量池中已经有cd了 直接引用
//        System.out.println(x1 == x2);

        // 上面是1.8及以后的代码 1.6以后是把变量拷贝一份
        x2.intern();//x2把变量存到常量池中
        String x1 = "cd";//复制一份cd
        System.out.println(x1 == x2);



    }
}
