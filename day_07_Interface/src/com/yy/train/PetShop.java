package com.yy.train;

import java.util.Scanner;

public class PetShop {
     public static void main(String[] args) {
    	 System.out.println("��ӭ���������̵�!\n�����Ҫ�����ĳ���"
				+ "������ְɣ�");
    	 Pet.name=new Scanner(System.in).nextLine();
    	 
    	 System.out.println("��ѡ��Ҫ�����ĳ�������(1������  2�����)");
    	 String str1=new Scanner(System.in).nextLine();
    	 if("1".equals(str1)){
    		 Dog dog=new Dog();
    		 dog.setHealth(100);
    		 System.out.println("��ѡ�񹷹���Ʒ��(1����������������Ȯ  2������ѩ����)");
    		 String str2=new Scanner(System.in).nextLine();
    		 if("1".equals(str2)){
    			 dog.setType("��������������Ȯ");
    		 }else if("2".equals(str2)){
    			 dog.setType("����ѩ����");
    		 }else{
    			 System.out.println("û������Ʒ��������������ȷָ�");
    		 }
    		 System.out.println("������԰�:");
    		 dog.showPet();
    	 }else if("2".equals(str1)){
    		 Penguin penguin=new Penguin();
    		 penguin.setHealth(100);
    		 System.out.println("��ѡ�������Ա�(1��Q��  2��Q��)");
    		 String str3=new Scanner(System.in).nextLine();
    		 if("1".equals(str3)){
    			 penguin.setSex("Q��");
    		 }else if("2".equals(str3)){
    			 penguin.setSex("Q��");
    		 }
    		 System.out.println("������԰�:");
    		 penguin.showPet();
    	 }
	}
}
