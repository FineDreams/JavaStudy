package com.yy.bookstore.utils.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SysMake {
    public String randomOid(){
            String sources = "0123456789";
            Random rand = new Random();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 6; j++)
            {
                sb.append(sources.charAt(rand.nextInt(9)) + "");
            }
            return sb.toString();
    }
    public String sysTime(){
        String time = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date());
        return time;
    }
}
