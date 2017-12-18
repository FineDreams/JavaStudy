package com.yy.Rtest;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class test {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://api.douban.com/v2/book/1220562");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes=new byte[1024];
        int len=inputStream.read(bytes);
        String result=new String(bytes,0,len);
        System.out.println(result);

        JSONObject js=JSONObject.fromObject(result);
        
    }
}
