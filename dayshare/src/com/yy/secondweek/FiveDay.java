package com.yy.secondweek;

public class FiveDay {
    public static void main(String[] args) {
        Test.getTest();
        Test.getTest();

        Test2.getInstance();
        Test2.getInstance();
    }
}
class Test{
    private Test() {
        System.out.println("单例模式饿汉式!");
    }
    static Test test=new Test();
    public static Test getTest() {
        return test;
    }
}
class Test2{
    private Test2(){
        System.out.println("单例模式懒汉式!");
    }
    static Test2 test2=null;

    public static  Test2 getInstance(){
        synchronized (Test2.class) {
            if (test2 == null) {
                test2 = new Test2();
            }
        }
            return test2;
    }
}