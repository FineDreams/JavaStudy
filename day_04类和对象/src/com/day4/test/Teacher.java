package com.day4.test;

public class Teacher {
	String name;
    char sex;
    int age;
    double money;
    
    public void Teaching(){
    	System.out.println("�ҵĹ����ǽ�������");
    }
    public String Arrange(){
    	return "����ѧ��";
    }
    public void Set(String name){
       System.out.println("�ҵ�������:"+name);
    }
    public double Pay(double money){
    	return money;
    }
}
