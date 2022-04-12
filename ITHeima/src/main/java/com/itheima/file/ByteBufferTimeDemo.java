package com.itheima.file;

import java.io.*;

public class ByteBufferTimeDemo {
    private static final String SRC_FILE = "/Users/zhangmingming/Downloads/第三章 存储系统02的副本.mp4";
    private static final String DEST_FILE = "/Users/zhangmingming/Desktop/io";

    public static void main(String[] args) throws Exception {
        //使用低级的字节流按照一个一个字节的形式复制文件
//        copy1();
        //使用低级的字节流按照一个字节一个字节数组的形式复制文件
        copy2();
        //使用高级字节缓冲流一个一个字节的形式
//        copy3();
        //使用高级字节缓冲流一个字节数组一个字节数组的读写文件
        copy4();

    }

    private static void copy4() {
        long start = System.currentTimeMillis();
        try(
                //1、使用低级字节输入流与文件链接，把数据从硬盘中读取到内存中
                InputStream in = new FileInputStream(SRC_FILE);
                //1、1 使用高级缓冲流包装低级输入流
                InputStream bin = new BufferedInputStream(in);
                //2、使用低级字节输出流与文件链接，把数据从内存写入到硬盘中去 在低级输出流中才能写是否追加
                OutputStream out = new FileOutputStream(DEST_FILE+"video04.mp4");
                //2、2使用高级缓冲字节输出流包装低级字节输出流
                OutputStream bout = new BufferedOutputStream(out);
                ){
            //定义一个byte数组 指定原始大小为1024  用来制定每次读取多少个字节到内存中去
            byte[] bytes = new byte[1024*8];
            //定义一个int类型变量 用来接受接受每次读取了多少个字节
            int b;
            //字节输入流读取完毕会返回-1 说明读取完毕了
            while ((b = bin.read(bytes))!=-1){
                bout.write(bytes,0,b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用字节缓冲流读写文件耗时："+(end-start)/1000.0+"s");
    }

    private static void copy3() {
        long start = System.currentTimeMillis();
        try(
                //1、创建低级的字节输入流与源文件接通
                InputStream in = new FileInputStream(SRC_FILE);
                //2、把原始的低级字节输入流包装成高级字节输入缓冲流
                InputStream bin = new BufferedInputStream(in);
                //3、创建低级的字节输出流与目标文件接通
                OutputStream out = new FileOutputStream(DEST_FILE+"video03.mp4");
                //4、创建高级的字节缓冲流包装低级的字节输出流
                OutputStream bout = new BufferedOutputStream(out);
                ){
                //5、定义个变量记录每次读取的字节 一个字节一个字节的读取
                int b;
                while ((b = bin.read())!=-1){
                        bout.write(b);
                }
            bout.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用高级字节缓冲流一个字节一个字节的读写数据耗时："+(end-start)/1000.0+"s");
    }

    private static void copy2() throws Exception {
        File sf = new File(SRC_FILE);
        File df = new File(DEST_FILE);
        InputStream in = null;
        OutputStream out = null;
        long start = System.currentTimeMillis();
        if (!df.exists()){
            System.out.println("df路径不存在 则创建路径");
            if (df.mkdirs()){
                System.out.println("df路径创建成功");
                //1、和文件对象关联 把数据从硬盘中读取到内存
                in = new FileInputStream(sf);
                out = new FileOutputStream(df+File.separator+"video"+System.currentTimeMillis()+".mp4");
                int len;//记录每次读取的字节数
                byte[] bytes = new byte[1024*8];
                //定义一个int类型的中间变量用来接受读了多少个字节
                while((len = in.read(bytes))!=-1){
                    out.write(bytes,0,len);
                }
                out.flush();
                out.close();
            }
        }else {
            System.out.println("df路径存在 不用创建路径");
//            df.mkdir();
            in = new FileInputStream(sf);
            out = new FileOutputStream(df+File.separator+"video"+System.currentTimeMillis()+".mp4");
            int len;//记录每次读取的字节数
            //定义一个数组 转移数据
            byte[] bytes = new byte[1024];
            while((len = in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
            out.flush();
            out.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用低级的字节流按照一个字节数组的形式复制文件耗时：" + (end - start) / 1000.0 + "s");


    }

    private static void copy1() {
        File sf = new File(SRC_FILE);
        File df = new File(DEST_FILE);
        long start = System.currentTimeMillis();
        InputStream in = null;
        OutputStream out = null;
        try {
            //1、创建低级的字节输入流与源文件接通 把文件读取到内存中
            in = new FileInputStream(sf);
            //2、创建低级的字节输出流与目标文件接通 把文件从内存中写入到文件
            out = new FileOutputStream(df + "video01.mp4");

            int b;
            //默认每次读取一个字节
            while ((b = in.read()) != -1) {
                //那就写一个字节
                out.write(b);
            }
            out.flush();
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
        long end = System.currentTimeMillis();
        System.out.println("使用低级的字节流按照一个一个字节的形式复制文件耗时：" + (end - start) / 1000.0 + "s");
    }

}
