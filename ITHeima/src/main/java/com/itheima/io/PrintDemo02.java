package com.itheima.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintDemo02 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("锦瑟无端五十弦");
        System.out.println("一弦一柱思华年");

        // 改变输出语句的位置（重定向）
        PrintStream ps = new PrintStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/log.txt");
        System.setOut(ps);

        System.out.println("庄生晓梦迷蝴蝶");
        System.out.println("望帝春心托杜鹃");


    }
}
