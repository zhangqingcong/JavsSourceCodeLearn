package com.itheima.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo02 {
    public static void main(String[] args) throws IOException {
        //读取properties属性文件中的键值对信息
        //先创建一个空的容器用来接收
        Properties properties = new Properties();
        System.out.println(properties);

        //从流中加载属性文件的键值对数据到属性对象properties中去
        properties.load(new FileReader("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/resources/data1.properties"));

        System.out.println(properties);
        String dlei = properties.getProperty("dlei");
        String admin = properties.getProperty("admin");
        String heima = properties.getProperty("heima");
        System.out.println(dlei);
        System.out.println(admin);
        System.out.println(heima);
    }
}
