package com.day4.test;

public class Courier {
    String name;
    char sex;
    int age;
    double money;
    
    public void Work(){
    	System.out.println("我的工作是收发快递");
    }
    public String Arrange(){
    	return "收揽物品";
    }
    public void Set(String name){
       System.out.println("我的名字是:"+name);
    }
    public int Age(int age){
    	return age;
    }
}
