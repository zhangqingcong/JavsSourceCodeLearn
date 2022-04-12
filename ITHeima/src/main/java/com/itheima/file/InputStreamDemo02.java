package com.itheima.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用文件字节输入流每次读取一个字节的数据
 */
public class InputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        //1、创建一个文件字节输入流与源文件路径接通
        InputStream is =new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt");

        //2、定义一个字节数组，用于读取指定大小的字节数组
        byte[] bytes = new byte[3];//3B
        //Reads a byte of data from this input stream. 从此输入流中读取一个字节的数据。
        /**
         * 数据的下一个字节，如果到达文件末尾，则为 -1。
         */
        int read1 = is.read();//read不带参数 返回的是读取的内容
        //Reads up to b.length bytes of data from this input stream into an array of bytes.
        //从此输入流中读取最多 b.length 个字节的数据到字节数组中。
        /**
         * the total number of bytes read into the buffer, or -1 if there is no more data because the end of the file has been reached.
         * 读入缓冲区的总字节数，如果由于已到达文件末尾而没有更多数据，则为 -1。
         */
        int read = is.read(bytes);
        System.out.println(read);
        System.out.println(read1);
        int len = read;
        System.out.println("读取了几个字节："+len);
        String s = new String(bytes);
        System.out.println(s);
//
//        int len1 = is.read(bytes);
//        System.out.println("读取了几个字节："+len1);
//        String s1= new String(bytes);
//        System.out.println(s1);
//
//        int len2 = is.read(bytes);
//        System.out.println("读取了几个字节："+len2);
//        //读取多少字节 就倒出来多少字节
//        String s2= new String(bytes,0,len2);
//        System.out.println(s2);
//
//        int i= is.read(bytes);
//        System.out.println(i);//读取完毕返回-1

//        //3、使用while循环 每次读取一个指定大小的字节数组
//        byte[] bytes = new byte[3];
//        int len;//记录每次读取出来的字节内容
//        /**
//         * 一次循环 从流中读取bytes.length个长度的字节内容到bytes缓冲区中 用len记录本次循环中读取了多少个字节
//         * 这里的bytes既是代表每次读多少个字节回来，也代表把读取的内容放到bytes这个缓存区
//         */
//        while ((len = is.read(bytes))!=-1){
//            //读取多少 倒出来多少
//            /**
//             * Reads up to len bytes of data from this input stream into an array of bytes. If len is not zero, the method blocks until some input is available; otherwise, no bytes are read and 0 is returned.
//             * 这里的bytes就是每次循环读到的内容 每次都从0开始 len代表本次循环从刘中读了多少字节 就从byte数组中写多少个出去
//             * 下次循环中 不会清空上次读取的内容 而是覆盖 所以最后一次没有占满数组长度的话 最后一次读了多少个len 就写多少个len出去
//             * 最后一次前len长度等于bytes.length
//             */
//            System.out.println(new String(bytes,0,len));
//        }


    }
}
