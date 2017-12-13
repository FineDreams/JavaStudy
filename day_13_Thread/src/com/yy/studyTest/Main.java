package com.yy.studyTest;

public class Main {
    public static void main(String[] args) {
//继承Thread类
        threadPre st=new threadPre();
        threadPre st2=new threadPre();
        threadPre st3=new threadPre();
        new Thread(st).start();
        new Thread(st2).start();
        new Thread(st3).start();
//实现Runnable接口

//        runnablePre ru=new runnablePre();
//        new Thread(ru).start();
//        new Thread(ru).start();
//        new Thread(ru).start();

    }
}
