package com.itheima.file;

import java.io.*;

/**
 * 使用finally释放资源
 */
public class TryCatchFinallyDemo01 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        try {
            //1、创建一个字节输入流与源文件接通
            in = new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt");
            //2、创建一个字节输出流与源文件接通
            out = new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data4.txt");

            // 定义一个数组 每次从输入流中读取指定大小的数据 并存放到缓冲区中
            byte[] buffer = new byte[1024];
            // 定义一个变量 用来接收每次读取了多少个字节
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            System.out.println("复制完成");
            System.out.println(10 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //无论代码是否有异常 最终代码都会执行这里
            System.out.println("==========finally=================");
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("关闭成功");
        }
        System.out.println(test(10,2));
    }

    public static int test(int a,int b){
        try {
            int c = a/b;
            return c;
        }catch (Exception e){
            e.printStackTrace();
            return -11111111;//计算出现bug
        }finally {
            System.out.println("----finally----");
            //开发中这里不建议加return 否则永远会返回这里的返回
            return 100;
        }

    }
}
