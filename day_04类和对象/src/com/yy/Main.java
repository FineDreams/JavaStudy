package com.yy;

public class Main {
    public static void main(String[] args){
    	//创建对象的过程
    	//什么是对象
     Car car=Car.getInstance();
       //Car就是类
       //car就是对象
       //是根据Car这个类创建出来的
         car.setMark("鄂A-344434");
  	     car.setColor("red");
  	     car.showInfo();
  	     
//  	  这里将car的地址传给了car2
//  	 Car car2=car;
  	     
  	 Car car2=Car.getInstance();
  	     car2.setCar("鄂B-897887", "blue");
  	     car2.showInfo();
  	     
  	    System.out.println(car==car2);
  	    System.out.println(car.equals(car2));
    }
}
