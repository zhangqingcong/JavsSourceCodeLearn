package com.company.jvm.GC;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示弱引用--发现即回收
 * 内存不够的时候会出发垃圾回收 但是只回收够够用的就行了 不会把所有的弱链接都释放掉
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class Demo2_5_WeakReference {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w : list) {
                System.out.println(w.get()+" ");
            }
            System.out.println();
        }
        System.out.println("循环结束："+list.size());
    }
}
