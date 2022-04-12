package com.itheima.io;

import java.io.*;

public class ByteBufferDemo01 {
    public static void main(String[] args) {
        try(
                //这里只能放置资源对象，用完自动关闭，自动调用资源对象的close方法关闭资源--即使出现异常也会做关闭操作 要实现AutoCloseable接口
                //1、创建一个字节输入流管道与源文件接通 设置追加属性在低级输出流里面 不再高级流里面
                InputStream in = new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt");
                //1、1 把原始的字节输入流包装成高级的缓冲字节输出流
                InputStream bis = new BufferedInputStream(in);
                //2、创建一个字节输出流管道与目标文件接通
//                OutputStream out = new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data4.txt");
                OutputStream out = new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data4.txt",true);
                //2、2 把原始的字节输出流包装成缓冲字节输出流
                OutputStream bout = new BufferedOutputStream(out);
                )
        {
            //3、定义一个字节数组转移数据
            byte[] buffer = new byte[1024];
            int len;//记录每次读取的字节数
            while((len = bis.read(buffer))!=-1){
                bout.write(buffer,0,len);
            }
            bout.write("\r\n".getBytes());
            bout.flush();
            System.out.println("复制完成");
        }catch (Exception e){

        }
    }
}
