package com.yy.study;

public class DogMain {
   public static void main(String[] args){
	   Dog dog=new Dog();
	   Dog dog1=new Dog("����");
	   Dog dog2=new Dog("����",30);
	   Dog dog3=new Dog(30,"����");
	    
	   //����ֵ������ʱ��Ͳ�����Ϊ
	   //��ͬ����֮����ж�����
	   dog.eatBone();
	   dog.eatBone();
   }
}
