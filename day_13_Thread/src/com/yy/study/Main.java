package com.yy.study;

import com.yy.HelloThread;

public class Main {

    private static Thread thread;

    public static void main(String[] args) {
        /*
        线程:Thread
        什么是线程
        在讲线程之前，来说一下什么是进程
        进程就是一个程序

        线程是程序中的执行单元

        进程中可以有多个线程

        正常情况下，每个线程都有自己独立的执行流程
        互不干扰

       如果人为写的话，可以让两个线程产生交集

         */
        //创建一个Thread的子类
//        thread = new HelloThread();

        //创建一个Runnable接口的实现类
//        thread=new Thread(new HelloRunnable());

        //什么叫内部类?
        //定义在一个类内部的类，就叫内部类
        //没有名字的对象叫匿名对象
        //那么没有名字的类就叫匿名类
        //这个类又写在另一个类内部，
        //所以我们叫它匿名内部类

//        创建线程的第三种方式
//       thread=new Thread(new Runnable() {
//           @Override
//           public void run() {
//               for (int i = 0; i <1000 ; i++) {
//                   System.out.println("我是匿名内部类中的run:"+i);
//               }
//           }
//       });

//        创建线程的第四种方式
//        thread=new Thread(){
//            @Override
//            public void run() {
//                super.run();
//            }
//        };

        //starts方法，才是真正开启一个线程
        //thread.run()，只是 调用了某个对象的方法
        //并没有开启线程
        //自然也就不会出现互相交替输出的现象

        //开启一个线程
        thread.start();
        for (int i = 0; i <100 ; i++) {
            //Thread的静态方法currentThread
            //可以帮助我们获得当前正在执行的线程对象
            //调用这个线程对象的getName方法获得名字
            System.out.println(Thread.currentThread().getName()+"------"+i);
        }
    }

}
