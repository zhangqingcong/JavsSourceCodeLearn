package com.itheima.io;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序出师表的顺序 并输出到另外一个文件中
 */

public class BufferCharTest3 {
    public static void main(String[] args) {
        //1、创建文件对象定位操作文件
        File sf = new File("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/出师表.txt");
        File df = new File("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/出师表01.txt");
        try (
                //1、创建低级文件字符输入流与文件链接
                Reader r = new FileReader(sf);
                //1、1创建高级缓冲字符输入流包装低级字符输入流
                BufferedReader br = new BufferedReader(r);
                //2、创建低级文件字符输出流与文件链接
                Writer w = new FileWriter(df);
                //2、2创建高级缓冲字符输出流包装低级字符输出流
                BufferedWriter bw = new BufferedWriter(w);
        ) {
            //3、定义一个List集合存储读取出来的每行内容
            List<String> data = new ArrayList<>();
            //5、自定义排序规则
            List<String> sizes = new ArrayList<>();
            //4、定义循环
//            char[] buffer = new char[(int) sf.length()];
            String line;
            while((line = br.readLine())!=null){
                if (line.isEmpty()){
                    continue;
                }
                data.add(line);

            }
            System.out.println(data);
            Collections.addAll(sizes,"一","二","三","四","五","六","七","八","九","十");

            Collections.sort(data, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String s1 = o1.substring(0, o1.indexOf("、"));
                    String s2 = o2.substring(0, o2.indexOf("、"));
                    int indexOf1 = sizes.indexOf(s1);
                    int indexOf2 = sizes.indexOf(s2);
                    return indexOf1-indexOf2;//升序排列
//                    return indexOf2-indexOf1;//降序排列
                }
            });
            System.out.println(data);

            //6、遍历集合中的每行文章写出去，且要换行
            for (String datum : data) {
                bw.write(datum);
                bw.newLine();//换行
            }
            bw.flush();
        } catch (Exception e) {

        }
    }
}
