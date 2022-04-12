package com.company.jvm;

import java.util.ArrayList;
import java.util.List;

public class Demo1_13 {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        System.out.println("执行中...");
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
        Thread.sleep(10000000000L);
    }
}
class Student{
    private byte[] big = new byte[1024*1024];
}
