package com.yy.training;

public class ExtendsTest {
   public static void main(String[] args){
	   Child c=new Child();
	   c.pet("继承父类");
	   c.hitChild();
   }
}
class Fathertest{
	public void pet(String str){
		System.out.println(str);
	} 
}
interface stepFather{
	public void hitChild() ;
}
class Child extends Fathertest implements stepFather{
	public void hitChild(){
		System.out.println("实现接口");
	}
}