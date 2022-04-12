package com.company.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码演示 StringTable 位置
 * 在jdk8下设置 ——xmx10m -XX:-UseGCOverheadLimit
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 * java.lang.OutOfMemoryError: Java heap space
 */
public class Demo1_6_OOME_HeapSpace {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try{
            for (int i1 = 0; i1 < 260000; i1++) {
                list.add(String.valueOf(i1).intern());
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
