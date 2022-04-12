package com.itheima.file;

import java.io.*;

/**
 * 使用文件字节输入流一次读完文件的全部字节。可以解决乱码问题
 */
public class InputStreamDemo03 {
    public static void main(String[] args) throws IOException {
        //1、创建一个文件字节输入流与源文件接通
        File f = new File("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt");
        InputStream is = new FileInputStream(f);

        //2、定义一个字节数组与文件的大小刚刚一样大
        byte[] bytes = new byte[(int) f.length()];
        int byteContext = is.read(bytes);
        System.out.println("读取了多少个字节："+byteContext);
        System.out.println("文件大小："+f.length());
        System.out.println(new String(bytes));

    }
}
