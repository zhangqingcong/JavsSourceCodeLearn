package com.itheima.serializable01;

import java.io.*;

/**
 * 把磁盘中的数据恢复成对象
 */
public class ObjectInputStream01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1、创建对象输入流管道包装低级的字节输入流管道
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/obj.txt"));

        //1、先创建文件字节输入流与文件联通
        InputStream is = new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/obj01.txt");
        //1、1 创建对象输入流管道包装低级文件字节输入流管道
        ObjectInputStream ois = new ObjectInputStream(is);
        //2、调用对象字节输入流的反序列化方法
//        Student s = (Student) ois.readObject();
        Student s1 = (Student) ois.readObject();
        System.out.println(s1);
    }
}
