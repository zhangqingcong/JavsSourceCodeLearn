package com.company.jvm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 */
public class Demo1_10_DirectMemoryOutOfMemoryError {
    static int _100MB = 1024 * 1024 *100;
    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i =0;
        try{
            while(true){
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100MB);
                list.add(byteBuffer);
                i++;
            }
        }finally {
            System.out.println(i);
        }
    }
}
