package com.test;

public class Student {
	
	//这三个都叫属性
	//现在这三个属性还没有值
    String name;
    String school;
    String id;
    
    public void play(){
    	System.out.println(name+"玩游戏去了");
    }
    public void goToStudy(){
    	System.out.println(name+"去上学了，学校是"+school);
    }
    
    /*
     * public         权限修饰符
     * void           返回值类型
     *              void表示：没有返回值
     * show           方法名
     * (String str)   参数列表
     * {}             方法体：
     *                      当这个方法被调用时，要执行的代码
     */
    public void show(String str){
    	this.name=name;
    	this.school=school;
    	
    }
    public void buyFood(int money){
    	System.out.println("拿着老师的"+money+"块钱去打游戏来了");
    }
    public void add(int a,int b){
    	int sum=a+b;
    	System.out.println("和为:"+sum);
    }
    
    //public后面的这个String
    //表示返回值的类型是String,是字符串
    public String hot(String food){
    	return "加热了的"+food;
    }
}
