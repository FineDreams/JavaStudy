package com.yy;

public class Main {
    public static void main(String[] args){
    	//��������Ĺ���
    	//ʲô�Ƕ���
     Car car=Car.getInstance();
       //Car������
       //car���Ƕ���
       //�Ǹ���Car����ഴ��������
         car.setMark("��A-344434");
  	     car.setColor("red");
  	     car.showInfo();
  	     
//  	  ���ｫcar�ĵ�ַ������car2
//  	 Car car2=car;
  	     
  	 Car car2=Car.getInstance();
  	     car2.setCar("��B-897887", "blue");
  	     car2.showInfo();
  	     
  	    System.out.println(car==car2);
  	    System.out.println(car.equals(car2));
    }
}
