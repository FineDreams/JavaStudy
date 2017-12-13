package com.yy.study;

import org.junit.Test;

import java.io.*;

public class BufferDemo {
    @Test
    public void showRead() throws IOException {
        FileReader fr=new FileReader("src/com/yy/study/线程之前的复习");

        //将字符读取流传到构造方法中
        BufferedReader br=new BufferedReader(fr);

        String line=null;

        StringBuffer sb=new StringBuffer();

        //readLine方法，一读读一行
        //如果什么都没读到
        //返回null
        while((line=br.readLine())!=null){
            //将读取到的内容，添加到sb中
            sb.append(line+"\n");
        }
        System.out.println(sb);

    }
    @Test
    public void showWrite() throws IOException {
        FileWriter fw=new FileWriter("src/com/yy/study/showWrite.txt");

        BufferedWriter bfw=new BufferedWriter(fw);
        for (int i = 0; i <20 ; i++) {
            bfw.write(i+"");
            bfw.newLine();//新来一行

        }
        bfw.flush();//将流中的内容刷新到文件
    }
}
