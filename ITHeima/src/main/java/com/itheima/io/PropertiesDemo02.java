package com.itheima.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertiesDemo02 {
    public static void main(String[] args) throws IOException {
        //读取键值对信息
        Properties p = new Properties();
        System.out.println(p);
        Reader r = new FileReader("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/log1.txt");
        p.load(r);

        System.out.println(p);
        System.out.println(p.get("dlei"));
        System.out.println(p.get("admin"));
        System.out.println(p.get("heima"));
    }
}
