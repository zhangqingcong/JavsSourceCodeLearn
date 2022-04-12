package com.itheima.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferedWriterDemo2 {
    public static void main(String[] args) {
        try {
            //1、创建一个字符输出流管道与目标文件接通
            Writer fw = new FileWriter("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/出师表02.txt");//覆盖输出 每次启动都会覆盖之前的数据
//            Writer fw = new FileWriter("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/出师表02.txt");

            //2、创建一个高级缓冲字符流包装低级输出流
            BufferedWriter bw = new BufferedWriter(fw);

            //public void write(int c) 写一个字符出去
            bw.write(98);
            bw.write('a');
            bw.write('徐');
            bw.newLine();

            //public void write(String str) 写一个字符串出去
            bw.write("abc我是中国人");
            bw.newLine();//bw.write("\r\n");

            char[] chars = "abc我是中国人".toCharArray();
            bw.write(chars);
            bw.write("\r\n");


            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
