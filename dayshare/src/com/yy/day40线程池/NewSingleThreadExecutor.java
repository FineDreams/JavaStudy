package com.yy.day40线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class NewSingleThreadExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 10; i++) {
            final int index=i;
            scheduledExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("嘻嘻嘻" + index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
