package com.day4.test;

public class Main {
    public static void main(String[] args){
    	//快递员
    	Courier courier=new Courier();
    	courier.Set("张三");
    	courier.Work();
    	System.out.println("我还会"+courier.Arrange());
    	System.out.println("我的年龄是:"+courier.Age(20));
    	System.out.println();
    	
    	//售货员
    	Salesman salesman=new Salesman();
    	salesman.Set("李四");
    	salesman.Work();
        System.out.println("实际上我就是"+salesman.Arrange());
        System.out.println("我的工资是:"+salesman.Pay(4000));
        System.out.println();

        //学生
        Student student=new Student();
        student.Set("王五");
        student.Work();
        System.out.println("我的任务就是"+student.Arrange());
        System.out.println("我的年龄是:"+student.Age(20));
        System.out.println();
        
        //老师
        Teacher teacher=new Teacher();
        teacher.Set("天天老师");
        teacher.Teaching();
        System.out.println("我的任务主要是"+teacher.Arrange());
        System.out.println("我的工资是:"+teacher.Pay(5000));
    }
}
