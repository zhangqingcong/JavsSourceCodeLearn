package com.itheima.serializable01;

import java.io.*;

/**
 * 对象序列化
 * 使用ObjectOutputStream把内存中的对象存到硬盘中去
 */
public class ObjectOutputStream01 {
    public static void main(String[] args) throws IOException {
        //1、创建学生对象
        Student s = new Student("汤姆", "tom", "123", 16);

        Student s1 = new Student("杰瑞","jerry","456",15);
        //2、对象序列化 使用对象字节输出流包装字节输出流管道
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/obj.txt"));

        //2、对象序列化 对象都是在内存中存贮的 首先使用文件字节输出流和文件联通
        OutputStream os = new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/obj01.txt");
        //2、1 使用对象输出流包装文件字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(os);

        //3、直接调用序列化方法
//        oos.writeObject(s);
        oos.writeObject(s1);
        oos.flush();
        oos.close();
    }
}
