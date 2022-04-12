package com.itheima.io;

import java.io.*;

public class BufferedReaderDemo1 {
    public static void main(String[] args) {
        try {
            //1、创建一个文件字符输入流与源文件接通
            Reader r = new FileReader("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/出师表.txt");
            //1、1把低级的文件字符输入流包装成高级的缓冲字符流
            BufferedReader br = new BufferedReader(r);

            //2、用循环 每次读取一个字符数组的数据
            char[] buffer = new char[1024];
            int len;
            while((len = br.read(buffer))!=-1){
                String s = new String(buffer,0,len);
                System.out.println(s);
            }

//            String line;
//            while ((line=br.readLine())!=null){
//                System.out.println(line);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
