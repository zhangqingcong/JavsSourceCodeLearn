package com.company.jvm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo1_9_DirectMemory {
    static final String FROM = "/Users/zhangmingming/Desktop/aa/bb.mp4";
    static final String TO = "/Users/zhangmingming/Desktop/cc/dd.mp4";
    static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        io();
        directBuffer();
    }
    private static void directBuffer() {
        long start = System.nanoTime();
        try {
            FileChannel from = new FileInputStream(FROM).getChannel();
            FileChannel to = new FileOutputStream(TO).getChannel();
            ByteBuffer bb = ByteBuffer.allocate(_1MB);
            while (true) {
                int len = from.read(bb);
                if (len == -1) {
                    break;
                }
                bb.flip();
                to.write(bb);
                bb.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("directBuffer 用时:" + (end - start) / 1000_000.0);
    }

    private static void io() throws IOException {
        long start = System.nanoTime();
        FileInputStream from = new FileInputStream(FROM);
        FileOutputStream to = new FileOutputStream(TO);
        byte[] buf = new byte[_1MB];
        while (true) {
            int len = from.read(buf);
            if (len == -1) {
                break;
            }
            to.write(buf, 0, len);
        }
        long end = System.nanoTime();
        System.out.println("io 用时：" + (end - start) / 1000_000.0);
    }
}
