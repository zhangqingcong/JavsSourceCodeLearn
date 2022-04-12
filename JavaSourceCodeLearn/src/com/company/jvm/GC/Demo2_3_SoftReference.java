package com.company.jvm.GC;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示软引用--内存不足即回收
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * 软引用 当内存不够的时候 垃圾回收时 会把所有的对象都回收
 */
public class Demo2_3_SoftReference {
    private static final int _4MB = 4 * 1024 *1024;

    public static void main(String[] args) throws IOException {
//        List<byte[]> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(new byte[_4MB]);
//        }
//        System.in.read();
        soft();
    }

    public static void soft(){
        //list --> SoftReference --> byte[]
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("循环结束："+list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }

}
