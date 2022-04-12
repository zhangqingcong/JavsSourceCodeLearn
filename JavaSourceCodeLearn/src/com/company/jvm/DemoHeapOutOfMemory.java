package com.company.jvm;
import jdk.internal.org.objectweb.asm.*;

/**
 * 堆内存溢出
 */
public class DemoHeapOutOfMemory extends ClassLoader{
    public static void main(String[] args) {
        int j = 0;
        try{
            DemoHeapOutOfMemory test = new DemoHeapOutOfMemory();
        for (int i = 0; i < 10000; i++,j++) {
            //ClassWriter 作用是生成类的二进制字节码
            ClassWriter cw = new ClassWriter(0);
            // 版本号 public 类名 包名 父类 接口
            cw.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
            byte[] code = cw.toByteArray();
            test.defineClass("Class"+i,code,0,code.length);
        }
        }finally{
            System.out.println(j);
        }
    }
}
