package com.itheima.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * 以内存为基准，把磁盘文件的数据以字符的形式读到内存
 *
 */
public class FileReaderDemo01 {
    public static void main(String[] args) throws Exception {
    //读取一个字符
        //1、创建一个字符输入流与源文件接通
        Reader r = new FileReader("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt");

        //2、读取一个字符返回 读取完毕返回-1
//        int context = r.read();
//        System.out.println((char) context);
//
//        int context2 = r.read();
//        System.out.println((char) context2);

        //3、使用循环读取字符
        int code;
        while ((code = r.read())!=-1){
            System.out.println((char) code);
        }

    }
}
