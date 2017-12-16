package com.yy.tcp.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class liSi {
    static int len=0;
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8080);
        Scanner input=new Scanner(System.in);
        Socket accept = ss.accept();
        byte[] buff=new byte[1024];
        InputStream is=accept.getInputStream();
        //获得与这个ServerSocket连接的Socket
        OutputStream os=accept.getOutputStream();
        StringBuffer sb=new StringBuffer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while ((len = is.read(buff)) != -1) {
                        sb.append(new String(buff, 0, len));
                        System.out.println(sb);
                        //把sb清空
                        sb.setLength(0);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        String result="";
        while ( (result =input.nextLine()).equals("quit")){
            os.write(result.getBytes());
        }
        ss.close();

    }
}
