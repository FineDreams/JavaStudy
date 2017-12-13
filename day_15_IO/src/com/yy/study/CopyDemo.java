package com.yy.study;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;

import java.io.*;
import java.text.Format;

public class CopyDemo {
    public static void main(String[] args) throws IOException {

        //需求是，把t1.txt中的内容
        //复制到target.txt中

        FileInputStream fs=new FileInputStream("src/com/yy/study/w.jpg");
        FileOutputStream fos=new FileOutputStream("src/com/yy/study/w2.jpg");
        byte[] buff=new byte[1024*1024];

                //返回值表示:读了多少字符
//        int len=fr.read(buff);
        int len=0;

        while ((len = fs.read(buff))!=-1){
            fos.write(buff);
        }
        fs.close();
        fos.close();

    }
}
