package com.yy.study;

public class DogMain {
   public static void main(String[] args){
	   Dog dog=new Dog();
	   Dog dog1=new Dog("旺财");
	   Dog dog2=new Dog("旺财",30);
	   Dog dog3=new Dog(30,"旺财");
	    
	   //返回值类型这时候就不能作为
	   //不同方法之间的判定条件
	   dog.eatBone();
	   dog.eatBone();
   }
}
