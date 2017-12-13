package com.yy.study;

public class Main2 {
    public static void main(String[] args) {
//        Thread thread=new Thread(new HelloRunnable());
//        thread.start();
        for (int i = 0; i <5 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        /*
        什么GC？
        GC是java中的垃圾回收机制
        java在内存中创建的对象那个，程序员不能手动销毁的
        这也是java相对c的一个好处
        c的程序员都需要手动销毁内存中的内容
        而我们java程序员就不需要做这个工作
        由java内边的机制帮助我们管理内存

        GC就是帮助我们把内存中不用的对象，销毁掉，释放内存空间

        当一个main方法执行时
        实际是启动了两个线程
        一个是我们能看到的主线程
        一个是在后台运行，我们看不见的GC

        注：GC什么时候销毁对象，由它自己决定，我们无法决定


         */

        /*
        线程的抢占式执行

        多个线程共同去争抢CPU的

         */
    }
}
