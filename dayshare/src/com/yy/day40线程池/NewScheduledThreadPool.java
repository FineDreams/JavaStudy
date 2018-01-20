package com.yy.day40线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("啊哈哈哈哈哈哈哈哈嗝");
            }
        },2, TimeUnit.SECONDS);
    }
}
