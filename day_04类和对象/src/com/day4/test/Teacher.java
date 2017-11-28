package com.day4.test;

public class Teacher {
	String name;
    char sex;
    int age;
    double money;
    
    public void Teaching(){
    	System.out.println("我的工作是教书育人");
    }
    public String Arrange(){
    	return "管理学生";
    }
    public void Set(String name){
       System.out.println("我的名字是:"+name);
    }
    public double Pay(double money){
    	return money;
    }
}
