package com.yy.train;

import java.util.Scanner;

public class PetShop {
     public static void main(String[] args) {
    	 System.out.println("欢迎来到宠物商店!\n请给您要领养的宠物"
				+ "起个名字吧！");
    	 Pet.name=new Scanner(System.in).nextLine();
    	 
    	 System.out.println("请选择要领养的宠物类型(1、狗狗  2、企鹅)");
    	 String str1=new Scanner(System.in).nextLine();
    	 if("1".equals(str1)){
    		 Dog dog=new Dog();
    		 dog.setHealth(100);
    		 System.out.println("请选择狗狗的品种(1、聪明的拉布拉多犬  2、酷酷的雪纳瑞)");
    		 String str2=new Scanner(System.in).nextLine();
    		 if("1".equals(str2)){
    			 dog.setType("聪明的拉布拉多犬");
    		 }else if("2".equals(str2)){
    			 dog.setType("酷酷的雪纳瑞");
    		 }else{
    			 System.out.println("没有其它品种啦，请输入正确指令！");
    		 }
    		 System.out.println("宠物的自白:");
    		 dog.showPet();
    	 }else if("2".equals(str1)){
    		 Penguin penguin=new Penguin();
    		 penguin.setHealth(100);
    		 System.out.println("请选择企鹅的性别(1、Q仔  2、Q妹)");
    		 String str3=new Scanner(System.in).nextLine();
    		 if("1".equals(str3)){
    			 penguin.setSex("Q仔");
    		 }else if("2".equals(str3)){
    			 penguin.setSex("Q妹");
    		 }
    		 System.out.println("宠物的自白:");
    		 penguin.showPet();
    	 }
	}
}
