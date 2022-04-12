package com.itheima.io;

import java.io.*;

public class OutputStreamWriterDemo02 {
    public static void main(String[] args) {
        try {
            //1、定义一个字节输出流
            OutputStream os = new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data3.txt");
            //2、把原始的字节输出流转换成字符输出流
            Writer w = new OutputStreamWriter(os,"GBK");//指定GBK字符集的方式写字符出去

            //3、把低级的字符输出流包装成高级的缓冲字符输出流
            BufferedWriter bw = new BufferedWriter(w);

            bw.write("我爱中国1～～～");
            bw.write("我爱中国2～～～");
            bw.write("我爱中国3～～～");
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
