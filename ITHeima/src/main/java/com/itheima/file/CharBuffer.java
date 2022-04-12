package com.itheima.file;


import java.io.*;

public class CharBuffer {
    private static final String DEST_FILE = "/Users/zhangmingming/Desktop/io";
    public static void main(String[] args) {
        try(
                Reader r = new FileReader("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/resources/道德经.txt");
                BufferedReader br = new BufferedReader(r);
                //true表示可以追加
                Writer w = new FileWriter(DEST_FILE+"道德经.txt",true);
                BufferedWriter bw = new BufferedWriter(w);
                ){
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
            String line;
            while ((line = br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }

        }catch (Exception e){}
    }
}
