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
	 System.out.println("Ʒ��:"+brand+"   ͨ��˫�ŵ���ǰ��");
 }
}
