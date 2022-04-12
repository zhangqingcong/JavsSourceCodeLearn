package com.itheima.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo03 {
    public static void main(String[] args) throws IOException {
        //1、创建一个文件字符输出流与源文件联通
//        Writer w = new FileWriter("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data4.txt"); //不追加 每次流都会覆盖上次
        Writer w = new FileWriter("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data4.txt",true);//追加 在上次内容之后追加

        //2、写一个字符出去 public void write(int c)
        w.write(98);
        w.write('a');
        w.write('8');
        w.write("徐");
        w.write("\r\n");
        // 写一个字符串出去 public void write(String str)
        w.write("我是中国人");
        w.write("\r\n");

        //public void write(char cbuf[]) 写一个字符数组出去
        char[] chars = "ABC我是中国".toCharArray();
        w.write(chars);
        w.write("\r\n");

        //写字符串的一部分出去  public void write(String str, int off, int len)
        w.write("abc我是中国人",0,5);
        w.write("\r\n");

        //写字符数组的一部分出去
        w.write(chars,2,4);
        w.write("\r\n");
        w.flush();//刷新流 不关闭流
        w.close();//刷新并关闭流

    }
}
