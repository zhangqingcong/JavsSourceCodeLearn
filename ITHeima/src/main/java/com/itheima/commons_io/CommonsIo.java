package com.itheima.commons_io;


import java.nio.file.Files;
import java.nio.file.Paths;


public class CommonsIo {
    public static void main(String[] args) throws Exception{
        //1、复制文件
//        IOUtils.copy(new FileInputStream("/Users/zhangmingming/Desktop/io出师表.txt"),
//                new FileOutputStream("/Users/zhangmingming/Desktop/new出师表.txt"));

        //2、复制文件到某个文件夹下
//        FileUtils.copyFileToDirectory(new File("/Users/zhangmingming/Desktop/io出师表.txt"),
//                new File("/Users/zhangmingming/Documents"));

        //3、完成文件夹复制到某个文件夹下
//        FileUtils.copyDirectoryToDirectory(new File("/Users/zhangmingming/Desktop/io"),
//                new File("/Users/zhangmingming/Documents/"));

//        FileUtils.deleteDirectory(new File("/Users/zhangmingming/Documents/new1"));

        Files.copy(Paths.get("/Users/zhangmingming/Desktop/io"),Paths.get("/Users/zhangmingming/Documents/new"));
    }
}
