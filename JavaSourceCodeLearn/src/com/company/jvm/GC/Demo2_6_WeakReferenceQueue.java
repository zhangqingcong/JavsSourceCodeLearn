package com.company.jvm.GC;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Demo2_6_WeakReferenceQueue {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        /**
         * 从队列中获取无用的 弱引用对象 并删除
         */
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("=================");
        System.out.println("循环结束：" + list.size());
    }
}
