package com.itheima.file;

import java.io.*;

public class FileReaderDemo2 {
    public static void main(String[] args) throws IOException {
        //1、创建一个文件字符输入流与源文件联通
        Reader r = new FileReader("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt");

        //2、用循环 每次读取一个字符数组的数据
        char[] buffer = new char[1024];//1K字符
        int len;
        while ((len = r.read(buffer))!=-1){
            String s = new String(buffer,0,len);
            System.out.println(s);
        }
    }
}
