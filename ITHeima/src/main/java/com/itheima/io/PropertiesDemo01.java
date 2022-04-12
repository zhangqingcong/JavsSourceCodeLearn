package com.itheima.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertiesDemo01 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.setProperty("admin","123456");
        properties.setProperty("dlei","456");
        properties.setProperty("heima","789");
        System.out.println(properties);

        /**
         * 保存数据到文件中
         */
        Writer w = new FileWriter("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/log1.txt");
        properties.store(w,"no comments");
    }
}
