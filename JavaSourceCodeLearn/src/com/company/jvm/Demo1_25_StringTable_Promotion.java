package com.company.jvm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo1_25_StringTable_Promotion {
    public static void main(String[] args) throws Exception {
        List<String> address = new ArrayList<>();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/zhangmingming/Desktop/test"), "utf-8"));
            String line = null;
            long start = System.nanoTime();
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                address.add(line.intern());
            }
            System.out.println("cost:" + (System.nanoTime() - start) / 1000000);
        }
        System.in.read();
    }
}