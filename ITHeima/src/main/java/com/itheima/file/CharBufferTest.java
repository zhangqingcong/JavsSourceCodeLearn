package com.itheima.file;

import java.io.*;
import java.util.*;

public class CharBufferTest {
    private static final String DEST_FILE = "/Users/zhangmingming/Desktop/io";
    public static void main(String[] args) throws IOException {
        try(
                BufferedReader br = new BufferedReader(new FileReader("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/resources/出师表.txt"));
//5、定义字符输出缓冲流管道与目标文件接通
                BufferedWriter bw = new BufferedWriter(new FileWriter(DEST_FILE+"出师表.txt",true));
        ){
            List<String> list = new ArrayList<>();
            //3、定义循环，按照行读取文件
            String line;
            while ((line = br.readLine())!=null){
                list.add(line);
            }
            //4、排序
            //自定义排序规则
            List<String> sizes = new ArrayList<>();
            Collections.addAll(sizes,"一","二","三","四","五","六","七");
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return sizes.indexOf(s.substring(0,s.indexOf(".")))
                            -sizes.indexOf(t1.substring(0,t1.indexOf(".")));
                }
            });
            System.out.println(list);
            //6、遍历集合中的每行数据而且都写出去
            for (String s : list) {
                bw.write(s);
                bw.newLine();
                bw.flush();
            }
        }catch (Exception e){

        }
        //1、创建字符输入缓冲流管道与源文件接通
        //2、定义一个List集合存储每行内容

//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);






    }
}
