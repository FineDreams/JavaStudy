package com.yy.abs;

public abstract class Weather {
    /*
     * 
     * abstract关键字：抽象的
     * 解释一下抽象：
     *     没有具体的对象，就是抽象
     *     抽象就是一个思维过程
     *     
     *类，对象，都是事物的抽象
     *     
     *abstract 修饰的类，就叫抽象类
     * 
     * 抽象类的特点：
     *    不能直接通过new关键字创建该抽象类的对象，
     *    也就是说，抽象不能new对象（实例化）
     *    
     *    有抽象方法的类，一定是一个抽象类
     *    但是，并不是说抽象类一定有抽象方法
     */
	
	//普通的方法
	public void show(){
		
	}
	
	//抽象方法：由abstract关键字修饰并且没有方法体的方法就是抽象方法
	
	public abstract void description();
}
