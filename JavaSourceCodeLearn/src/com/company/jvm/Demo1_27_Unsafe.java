package com.company.jvm;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

public class Demo1_27_Unsafe {
    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Unsafe unsafe = getUnsafe();
        //分配内存
        long base = unsafe.allocateMemory(_1Gb);
        unsafe.setMemory(base,_1Gb,(byte) 0);
        System.in.read();

        //释放内存
        unsafe.freeMemory(base);
        System.in.read();

    }

    public static Unsafe getUnsafe(){
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe = (Unsafe) theUnsafe.get(null);
            return unsafe;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
