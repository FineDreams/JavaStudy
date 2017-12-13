package com.yy.study;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        FileWriter fw=new FileWriter("src/com/yy/study/t1.txt");

        fw.write("安得广厦千万间，大庇天下寒士俱欢颜");
        fw.close();

    }
}
