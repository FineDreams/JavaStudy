package com.day4.test;

public class Courier {
    String name;
    char sex;
    int age;
    double money;
    
    public void Work(){
    	System.out.println("�ҵĹ������շ����");
    }
    public String Arrange(){
    	return "������Ʒ";
    }
    public void Set(String name){
       System.out.println("�ҵ�������:"+name);
    }
    public int Age(int age){
    	return age;
    }
}
