package com.yy.tcp.study;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendMain {
    public static void main(String[] args) throws IOException {

        //创建一个socket对象
        //指定目标的ip地址和端口号
        Socket socket=new Socket("192.168.20.210",8888);

        //获得socket对象的输出工具
        //这个东西我们叫做流
        OutputStream outputStream=socket.getOutputStream();

        //调用这个工具的写方法
        //把要传输的内容作为参数传进去
        //参数是一个字节数组
        outputStream.write("那你很棒棒哦".getBytes());

        //关闭socket
        socket.close();
    }
}
