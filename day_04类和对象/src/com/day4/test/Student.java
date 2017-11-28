package com.day4.test;

public class Student {
    String name;
    char sex;
    int age;
    double money;
    
    public void Work(){
    	System.out.println("我的工作是读书");
    }
    public String Arrange(){
    	return "好好学习";
    }
    public void Set(String name){
       System.out.println("我的名字是:"+name);
    }
    public int Age(int age){
    	return age;
    }
}
