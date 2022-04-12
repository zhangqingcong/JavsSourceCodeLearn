package com.itheima.io;

import java.io.*;

public class InputStreamReaderDemo01 {
    public static void main(String[] args) {
        // 代码使用UTF-8 文件使用GBK
        try {
            //1、提取GBK文件的原始字节流
//            InputStream is = new FileInputStream("/Users/zhangmingming/Desktop/log.txt");
            InputStream is = new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data3.txt");
            //2、把字节输入流转换成字符输入流
            Reader r = new InputStreamReader(is,"GBK");//告诉转换流 读取的时候读取到的就是字符输入流是按照GBK编码的
             BufferedReader br = new BufferedReader(r);
             String line;
             while ((line=br.readLine())!=null){
                 System.out.println(line);
             }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
