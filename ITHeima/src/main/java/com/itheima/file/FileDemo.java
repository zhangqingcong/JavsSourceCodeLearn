package com.itheima.file;

import java.io.File;
import java.net.URL;

/**
 * 使用File对象定位操作系统的文件
 */
public class FileDemo {
    public static void main(String[] args) {
        // /Users/zhangmingming/Desktop
        //1、根据文件路径创建文件对象 可以删除 获取文件信息 但是不能读写文件内容
        File f1 = new File("/Users/zhangmingming/Desktop/小猫.png");
        File f = new File(File.separator+"Users"+File.separator+"zhangmingming"+File.separator+"Desktop"+File.separator+"小猫.png");
        long size = f.length();//返回的是文件的字节大小
//        System.out.println(size);
//        System.out.println(f1.length());
//        System.out.println(File.separator);


//        String path = FileDemo.class.getClassLoader().getResource("data.txt").getPath();
//        System.out.println(path);
        //相对路径 默认到当前工程下寻找该文件
        File f2 =  new File("src/data.txt");

        boolean exists = f2.exists();
        System.out.println(exists);
        System.out.println(f2.length());

    }
}
