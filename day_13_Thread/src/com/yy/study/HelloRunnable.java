package com.yy.study;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("hello runnable:"+i);
        }
    }
}
