package com.itheima.bionioaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        //1、注册端口
        ServerSocket ss = new ServerSocket(8808);
        //2、开始在这里暂停等待接受客户端的链接，得到一个端到端的Socket管道
        Socket socket = ss.accept();
        //3、从Socket管道中的到一个字节输入流
        InputStream is = socket.getInputStream();
        //4、把字节输入流包装成自己需要的流进行数据的读取
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //5、读取数据
        String line;
        while ((line=br.readLine())!=null){
            System.out.println("服务端收到："+line);
        }
    }
}
