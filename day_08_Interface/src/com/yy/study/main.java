package com.yy.study;

import java.util.Scanner;

public class main {
      public static void main(String[] args) {
    	  
    	  //��������ã�ָ��������Ķ���
    	  //���Ƕ�̬��һ����
    	  Person person=new Teacher();
    	  Person p2=new Doctor();
    	  Person p3=new Student();
    	  
    	  
		Scanner input=new Scanner(System.in);
		System.out.println("����1����ʦ�ɻ����2��ҽ���ɻ�"
				+ ",����3��ѧ������");
	    
		//��ȡ����̨���������ֵ
		//���������������
		//��ִ�е��������ʱ���������̨
		//һֱ���������ݣ������ͻῨ������
		int choice=input.nextInt();
		Company2 company2=new Company2();
		if (choice==1){
//			Teacher t=new Teacher();
			company2.setPerson(person);
		}else if(choice==2){
//			Doctor doc=new Doctor();
            company2.setPerson(p2);
		}else if(choice==3){
			company2.setPerson(p3);
		}
		company2.work();
      }
}
