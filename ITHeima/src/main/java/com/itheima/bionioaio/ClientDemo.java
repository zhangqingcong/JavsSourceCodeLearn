package com.itheima.bionioaio;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws Exception{
        System.out.println("======客户端启动======");
        //1、创建一个socket的通信管道 请求与服务端的端口链接
        Socket socket = new Socket("127.0.0.1",8808);
        //2、从socket通信管道中获得一个字节输出流
        OutputStream os = socket.getOutputStream();
        //3、把字节流包装成自己需要的流进行数据的发送
        PrintStream ps = new PrintStream(os);
        //4、开始发送消息
        ps.println("我是客户端，我想约你吃小龙虾！！！");
        ps.flush();

    }
}
