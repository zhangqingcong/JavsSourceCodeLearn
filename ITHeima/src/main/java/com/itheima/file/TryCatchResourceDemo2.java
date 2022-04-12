package com.itheima.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * JDK 7 新增释放资源方式
 */
public class TryCatchResourceDemo2 {
    public static void main(String[] args) {

        try(
                InputStream in = new FileInputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data.txt");
                OutputStream out = new FileOutputStream("/Users/zhangmingming/IdeaProjects/ITHeima/src/main/java/data4.txt");
//                int age =23; 这里只能释放资源 只能定义实现了AutoCloseable接口的资源
                MyConnection myConnection = new MyConnection();
                ){
            //3、定义一个字节转移数组
            byte[] buffer = new byte[1024];
            int len;
            while ((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            System.out.println("复制成功");

        }catch (Exception e){

        }
    }

}
class MyConnection implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("链接资源被释放成功");
    }
}
