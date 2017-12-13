package com.yy;

public class HelloThread extends Thread {
    @Override
    public void  run() {
        super.run();
        for (int i = 0; i <100 ; i++) {
            System.out.println("hello thread"+"第"+i+"次运行");
        }

    }
}
