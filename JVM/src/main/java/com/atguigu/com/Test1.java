package com.atguigu.com;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        File f = new File("src/data.txt");
        System.out.println(f.length());
    }
}
