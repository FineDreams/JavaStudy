package com.day4.test;

public class Student {
    String name;
    char sex;
    int age;
    double money;
    
    public void Work(){
    	System.out.println("�ҵĹ����Ƕ���");
    }
    public String Arrange(){
    	return "�ú�ѧϰ";
    }
    public void Set(String name){
       System.out.println("�ҵ�������:"+name);
    }
    public int Age(int age){
    	return age;
    }
}
