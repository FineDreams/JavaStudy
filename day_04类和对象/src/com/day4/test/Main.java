package com.day4.test;

public class Main {
    public static void main(String[] args){
    	//���Ա
    	Courier courier=new Courier();
    	courier.Set("����");
    	courier.Work();
    	System.out.println("�һ���"+courier.Arrange());
    	System.out.println("�ҵ�������:"+courier.Age(20));
    	System.out.println();
    	
    	//�ۻ�Ա
    	Salesman salesman=new Salesman();
    	salesman.Set("����");
    	salesman.Work();
        System.out.println("ʵ�����Ҿ���"+salesman.Arrange());
        System.out.println("�ҵĹ�����:"+salesman.Pay(4000));
        System.out.println();

        //ѧ��
        Student student=new Student();
        student.Set("����");
        student.Work();
        System.out.println("�ҵ��������"+student.Arrange());
        System.out.println("�ҵ�������:"+student.Age(20));
        System.out.println();
        
        //��ʦ
        Teacher teacher=new Teacher();
        teacher.Set("������ʦ");
        teacher.Teaching();
        System.out.println("�ҵ�������Ҫ��"+teacher.Arrange());
        System.out.println("�ҵĹ�����:"+teacher.Pay(5000));
    }
}
