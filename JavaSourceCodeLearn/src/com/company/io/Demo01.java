package com.company.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args){
        try {
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeFile() throws IOException{
        //单个字节写
        //两个参数的构造参数 第一个参数是写到哪个目录下的哪个文件里面 会自动创建文件，但是目录不存在会报错
        //第二个参数代表是否追加 默认是false 如果不追加的话 写在同一个目录下的同名文件会覆盖
        // 单个字节的写
        FileOutputStream fos = new FileOutputStream("/Users/zhangmingming/a.txt",true);
        fos.write(10);
        fos.write((int)'a');
        System.out.println((int)'a');
        fos.write(32);//空格
        fos.write((int)'b');
        System.out.println((int)'b');
        fos.write(10);//换行
        fos.write((int)'c');
        System.out.println((int)'c');
    }
}
