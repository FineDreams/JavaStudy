package com.yy.day40线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduleAtFixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("嘿嘿嘿嘿额");
            }
        },2,3, TimeUnit.SECONDS);
    }
}
