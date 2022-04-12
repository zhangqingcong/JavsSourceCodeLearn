package com.itheima.file;

import java.io.*;

public class OutputStreamReader01 {
    public static void main(String[] args) {
        try(
                //1、定义一个字节输出流
                OutputStream out = new FileOutputStream("/Users/zhangmingming/Desktop/io/out01.txt");
                //2、把原始的字节输出流转换成字符输出流
//                Writer w = new OutputStreamWriter(out);//以默认的编码UTF-8写字符出去，跟直接写FileWriter一样
                Writer osw = new OutputStreamWriter(out,"UTF-8");
                //3、把低级的字符输出流转换成高级的缓冲字符输出流
                BufferedWriter bw = new BufferedWriter(osw);

        ){
            bw.write("我爱你中国1～～");
            bw.write("我爱你中国2～～");
            bw.write("我爱你中国3～～");
        }catch (Exception e){}
    }
}
