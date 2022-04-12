package com.itheima.io;

import java.io.*;

/**
 * 利用字节流的复制统计各种写法形式下缓冲流的性能执行情况
 * 复制流：
 * 1、使用低级的字节流按照一个字节一个字节的形式读写流来复制文件
 * 2、使用低级的字节流按照一个字节数组一个字节数组的形式复制文件
 * 3、使用高级的缓冲字节流按照一个字节一个字节大小的形式复制文件
 * 4、使用高级的缓冲字节流按照一个字节数组一个字节数组的形式复制文件
 */
public class ByteBufferTimeDemo {
    private static final String SF = "/Users/zhangmingming/Downloads/第三章 存储系统03.mp4";
    private static final String DF = "/Users/zhangmingming/Documents/io/a/b/c/d";

    public static void main(String[] args) {
        //1、低级流一个字节一个字节读写
//        copy1();
        //2、低级流一个字节数组一个字节数组的读写
//        copy2();
        //3、缓冲字节流一个字节一个字节的读写
//        copy3();
        //4、缓冲字节流一个字节数组一个字节数组的读写 这个耗时最短 开发优先使用这个
        copy4();
    }

    private static void copy4() {
        File sf = new File(SF);
        File df = new File(DF);
        long start = System.currentTimeMillis();
        try(
                //1、输入低级字节输入流与源文件接通
                InputStream in = new FileInputStream(sf);
                // 把原始的字节输入流包装成高级的缓冲字节输入流
                InputStream bin = new BufferedInputStream(in);
                //2、创建低级字节输数流与源文件接通
                OutputStream out = new FileOutputStream(df+File.separator+System.currentTimeMillis()+".mp4");
                //把低级字节输入流包装成高级缓冲字节输出流
                OutputStream bout = new BufferedOutputStream(out);
                )
        {
         //3、定义一个字节数组转移数据
         byte[] buffer = new byte[1024];
         int len;
         if (!df.exists()){
             df.mkdirs();
             while ((len=bin.read(buffer))!=-1){
                 bout.write(buffer,0,len);
             }
             bout.flush();
         }else {
             while ((len=bin.read(buffer))!=-1){
                 bout.write(buffer,0,len);
             }
             bout.flush();
         }

        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("高级缓冲字节流一个字节数组一个字节数组的读写数据所花费的时间："+(end - start)/1000.0+"s");
    }

    private static void copy3() {
        File sf = new File(SF);
        File df = new File(DF);
        InputStream in = null;
        InputStream bin = null;
        OutputStream out = null;
        OutputStream bout = null;

        try{
            in = new FileInputStream(sf);
            bin = new BufferedInputStream(in);
            int len;
            long start = System.currentTimeMillis();
            if (!df.exists()){
                df.mkdirs();
                out = new FileOutputStream(df+File.separator+System.currentTimeMillis()+".mp4");
                bout= new BufferedOutputStream(out);
                while ((len = bin.read())!=-1){
                    bout.write(len);
                }
                bout.flush();
            }else {
                out = new FileOutputStream(df+File.separator+System.currentTimeMillis()+".mp4");
                bout= new BufferedOutputStream(out);
                while ((len = bin.read())!=-1){
                    bout.write(len);
                }
                bout.flush();
            }
            long end = System.currentTimeMillis();
            System.out.println("高级缓冲字节流一个字节一个字节读写数据花费时间："+(end - start)/1000.0+"s");
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bin!=null){
                try {
                    bin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bout!=null){
                try {
                    bout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void copy2() {
        //1、创建文件对象 定位到要输入的文件地址
        File sf = new File(SF);
        //定位到文件要输出的地址
        File df = new File(DF);

        InputStream in = null;
        OutputStream out = null;
        try {
            //2、创建文件输入流与源文件联通
            in = new FileInputStream(sf);
            int len;//记录每次读取的文件字节数
            byte[] buffer = new byte[1024];
            long start = System.currentTimeMillis();
            if (!df.exists()) {
                df.mkdirs();
                System.out.println("文件路径不存在，创建新路径成功"+df.getAbsolutePath());
                out = new FileOutputStream("/Users/zhangmingming/Documents/io/"+ System.currentTimeMillis()+".mp4");
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                out.flush();
            } else {
                System.out.println("文件路径已经存在"+df.getAbsolutePath());
                out = new FileOutputStream(df +File.separator+ System.currentTimeMillis()+".mp4");
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                out.flush();
            }
            long end = System.currentTimeMillis();
            System.out.println("使用低级字节流一个字节数组一个字节数组的读写：" + (end - start) / 1000.0 + "s");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void copy1() {
        //1、创建文件对象 定位到要输入的文件地址
        File sf = new File(SF);
        File df = new File(DF);

        InputStream in = null;
        OutputStream out = null;
        long start = System.currentTimeMillis();
        try {
            //2、创建文件字节输入流与源文件沟通
            in = new FileInputStream(sf);
            //3、创建文件字节输出流与源文件接通
            int len;
            if (!df.exists()) {//先判断一下要输出文件的目录是否存在 不存在则要创建目录
                df.mkdirs();
                out = new FileOutputStream(df + File.separator + String.valueOf(System.currentTimeMillis()) + ".mp4");
                while ((len = in.read()) != -1) {//每次从流中读取一个字节
                    out.write(len);//每次往流中写入一个字节
                }
                System.out.println("流中的数据读写完毕要刷新");
                out.flush();
            } else {//目录文件已经存在 那么直接从流中写出即可
                while ((len = in.read()) != -1) {
                    out.write(len);
                }
                out.flush();
                System.out.println("流中的数据读写完毕要刷新");
            }
            long end = System.currentTimeMillis();
            System.out.println("低级流一个字节一个字节读写所花费的时间：" + (end - start) / 1000.0 + "s");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        }

    }
}
