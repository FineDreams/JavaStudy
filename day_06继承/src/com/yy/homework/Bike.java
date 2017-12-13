package com.yy.homework;

public class Bike extends Car{
   private String brand;

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}
   
 public void runStyle(){
	 System.out.println("品牌:"+brand+"   通过双脚蹬来前进");
 }
}
