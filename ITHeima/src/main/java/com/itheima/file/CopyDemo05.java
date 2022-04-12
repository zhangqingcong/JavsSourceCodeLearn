package com.itheima.file;

import java.io.*;

/**
 * 使用字节流完成文件的复制 支持一切文件类型的复制
 */
public class CopyDemo05 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        try{
             in = new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data4.txt");
             out = new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data5.txt");
            //定一个一个数组 规定每次读取多少
            byte[] buffer = new byte[1024];
            //记录每次读取的字节数
            int len;
            while ((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
