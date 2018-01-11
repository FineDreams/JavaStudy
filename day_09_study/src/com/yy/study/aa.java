package com.yy.study;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class aa {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
    }
}
