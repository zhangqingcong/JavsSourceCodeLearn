package com.itheima.file;

import java.io.*;

/**
 * IO流的体系：
 *              字节流                                 字符流
 *    字节输入流         字节输出流               字符输入流      字符输出流
 *    InputStream       OutputStream            Reader          Writer      这些都是接口
 *    FileInputStream   FileOutputStream        FileReader      FileWriter  接口其中的一些实现类
 * 文件字节输入流：
 *      -- 作用：以内存为基准，把磁盘中的数据以字节的形式读取到内存中
 *              按照字节读取文件到内存中。
 *      -- 构造器：
 *             public FileInputStream(File file):创建字节输入流管道与源文件对象接通
 *             public FileInputStream(String pathname)：创建字节输入流管道与源文件路径接通。
 *      -- 方法：
 *             public int read(): 每次读取一个字节返回，读取完毕返回-1。
 *       小结：
 *          一个一个字节读取中文数据输出其实是被淘汰的，性能极差！
 *          一个一个字节读取中文数据输出，会出现截断中文字节的情况，无法避免读取中文输出乱码的问题。
 */
public class InputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //1、创建一个文件字节输入流管道与源文件路径接通
        InputStream in = new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt");
        //1、创建一个文件字节输入流管道与源文件接通
//        InputStream in = new FileInputStream(new File("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt"));

        //2、读取一个字节返回 注意 read()方法返回的是读取了多少个字节的内容 一次一次的循环往复 这里不理解
        //是应为定义的byte[]数组是指每次读取这么长的内容 最后一次前len长度和byte[]数组大小应该一直 最后一次可能读到不满byte[]数组长度 只有len个
        //所以每次都应该到出去len个
        int context = in.read(); //0110 0001
        System.out.println(context);
//
//        int context2 = in.read();
//        System.out.println((char)context2);
//
//        int context3 = in.read();
//        System.out.println((char)context3);
//
//        int context4 = in.read();
//        System.out.println(context4);
//        //读取完毕 返回-1
//        int context5 = in.read();
//        System.out.println(context5);

        //3、使用循环改进

        //定义一个变量用来接收每次读到的字节
//        int b;
//        while ((b = in.read())!=-1){// a 0110 0001 b 0110 0010 c 0110 0011
//            System.out.print((char)b);//一个字节一个字节的去读 中文无论是GBK两个字节表示 UTF-8用三个字节表示中文 都无法避免出现乱码 英文和数字用一个字节表示 不会有问题
//        }




    }
}
