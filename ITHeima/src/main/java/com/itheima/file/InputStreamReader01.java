package com.itheima.file;

import java.io.*;

/**
 * InputStreamReader(InputStream in) Creates an InputStreamReader that uses the default charset.
 * InputStreamReader(InputStream in, String charsetName) Creates an InputStreamReader that uses the named charset.
 * InputStreamReader(InputStream in, Charset cs) Creates an InputStreamReader that uses the given charset.
 * InputStreamReader(InputStream in, CharsetDecoder dec) Creates an InputStreamReader that uses the given charset decoder.
 */

//文件编码和代码编码不一致会出现乱码现象
public class InputStreamReader01 {
    public static void main(String[] args) {
        /**
         * 解决方案
         * 使用字符输入转换流
         * 可以提取文件（如GBK编码）的原始字节流，原始字节不会存在问题
         * 然后把得到的原始字节流转换成制定编码的字符输入流，这样字符输入流中的字符就不会有乱码了
         */
        try (
                //代码是UTF-8 文件编码也是UTF-8 所以不会出现乱码现象
                //这是一个低级的文件字符输入流
//                Reader r = new FileReadeader("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/resources/data.txt");
//                Reader r = new FileReader("/Users/zhangmingming/Desktop/io/gbk11.txt");//abc�Ұ����й�
                //提取文件的原始字节输入流
                InputStream in = new FileInputStream("/Users/zhangmingming/Desktop/io/gbk11.txt");

//                Reader r = new InputStreamReader(in);//默认仍然以UTF-8编码转换成字符流
                Reader r = new InputStreamReader(in, "GBK");//以源文件GBK编码转换成字符输入流
                //把文件字符输入流转换成字符缓冲输入流
                BufferedReader br = new BufferedReader(r);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            /**
             * 如果要控制写出去的字符使用的编码
             * 1、可以把字符以指定编码获取字节后在使用字节输出流写出去
             *      "我爱你中国".getBytes(编码)
             * 2、也可以使用字符输出转换流
             */

        } catch (Exception e) {

        }
    }
}
