package com.itheima.io;

import java.io.*;

public class PrintDemo01 {
    public static void main(String[] args) {
        try {
            //1、创建一个文件字节输出流对象
            OutputStream os = new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/out.txt",true);
            //2、创建一个打印流对象 包装文件字节输出流
//            PrintStream ps = new PrintStream(os,true);//这里的true是是否自动刷新 不是追加 开启追加要在原始低级流那里开启

            PrintWriter ps = new PrintWriter(os,true);//PrintWriter和PrintStream的使用没有差别


            ps.println(97);
            ps.println('a');
            ps.println(23.3);
            ps.println(true);
            ps.println("我是打印流输出的，我是啥就打印啥");

            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
