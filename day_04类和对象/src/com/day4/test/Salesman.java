package com.day4.test;

public class Salesman {
    String name;
    char sex;
    int age;
    double money;
    
    public void Work(){
    	System.out.println("���˽���");
    }
    public String Arrange(){
    	return "����Ʒ��";
    }
    public void Set(String name){
       System.out.println("�ҵ�������:"+name);
    }
    public int Pay(int money){
    	return money;
    }
}
