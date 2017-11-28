package com.day4.test;

public class Salesman {
    String name;
    char sex;
    int age;
    double money;
    
    public void Work(){
    	System.out.println("收账结账");
    }
    public String Arrange(){
    	return "卖商品的";
    }
    public void Set(String name){
       System.out.println("我的名字是:"+name);
    }
    public int Pay(int money){
    	return money;
    }
}
