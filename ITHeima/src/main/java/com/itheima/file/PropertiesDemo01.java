package com.itheima.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("admin","123456");
        properties.setProperty("heima","123456");
        properties.setProperty("dlei","123456");
        System.out.println(properties);

         properties.store(new FileWriter("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/resources/data1.properties",true),
                 "这个参数是一个评论 无实际意义");


    }

}
