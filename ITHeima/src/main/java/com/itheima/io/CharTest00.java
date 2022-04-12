package com.itheima.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 代码字符编码集与文件字符编码集相同和不同的
 */
public class CharTest00 {
    public static void main(String[] args) {
        try(
                //1、ide使用UTF-8字符集 文件编码也用UTF-8字符集 不会乱码
                //1、创建一个文件字符输入流与源文件接通
                Reader r = new FileReader("/Users/zhangmingming/Desktop/log.txt");

                //2、使用高级的缓冲字符输入流包装低级字符输入流
                BufferedReader br = new BufferedReader(r);

                )
        {
            String line;
            while ((line = br.readLine())!=null){
                System.out.println(line);//�Ұ����й�ABC123abc 源文件的字符编码是gbk
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
