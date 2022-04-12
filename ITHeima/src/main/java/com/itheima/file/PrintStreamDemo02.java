package com.itheima.file;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo02 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("锦瑟无端五十弦");
        System.out.println("一弦一柱思华年");

        //改变输出语句的位置
        PrintStream ps = new PrintStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/resources/data.txt");


        System.setOut(ps);
        System.out.println("庄生晓梦迷蝴蝶");
        System.out.println("望帝春心托杜鹃");
    }
}
