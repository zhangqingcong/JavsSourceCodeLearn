package com.itheima.file;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 对文字进行编码和解码，为以后用到的场景作准备
 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //1、编码：使用指定的编码方式把文字转换成字节
        /**
         * utf-8 英文占一个字节 中文占用三个字节
         *  gbk 英文占用一个字节 中文占用两个字节 国标码 中国人设计的 在兼容的ASCII的基础上 使用两个字节表示汉子
         */
        String s = "abc我爱你中国";
//        byte[] bytes = s.getBytes();//不指定编码方式的话会默认使用idea的编码格式 UTF-8
        byte[] bytes = s.getBytes("GBK");
        System.out.println(bytes.length);
        System.out.println(bytes);
        System.out.println(Arrays.toString(bytes));


        //2、解码 把字节转换成中英文 编码前 编码后 的字符集必须一致 否则乱码
//        String s1 = new String(bytes);//默认使用IDEA使用的编码
        String s1 = new String(bytes,"GBK");//默认使用IDEA使用的编码
        System.out.println(s1);


    }
}
