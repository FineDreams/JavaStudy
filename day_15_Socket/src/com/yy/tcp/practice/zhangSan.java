package com.yy.tcp.practice;

import com.yy.udp.util.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class zhangSan {
    static String send="";
    public static void main(String[] args) throws IOException {
        //把张三写成发送方

        Socket socket=new Socket(Constants.ADDRESS,8080);

        Scanner input=new Scanner(System.in);
        //获得socket对象的输出工具
        OutputStream out = socket.getOutputStream();

        InputStream is=socket.getInputStream();
        byte[] buff=new byte[1024];

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!(send = input.nextLine()).equals("quit")) {
                    //如果输入的内容不是quit，那么程序继续
                    try {
                        out.write(send.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        int l =0;
        StringBuffer sb=new StringBuffer();
        while ((l=is.read(buff))!=-1){
            sb.append(new String(buff, 0, l));
            System.out.println(sb);
            sb.setLength(0);
        }
        //如果输入了quit，则循环会终止
        //那么关闭这个socket
        socket.close();

    }
}
