package com.lanou3g.main;

public class StringDemo {
   public static void main(String[] args){
	   /*
	    * String ��
	    * ��ʾ�ַ���
	    * ע�⣬�ַ������ǻ�����������
	    */
	   //�ַ����ǲ��ɱ�ģ���һ���ַ�����������
	   //���Ͳ����ٷ����仯
	   String s1="����";
	   String s2="����";
	   String s3=new String("����");
	   String s4=new String("����");
	   System.out.println(s1==s2);
	   
	   //equals ���ַ����ķ���
	   //��Ҫ���ַ�����������ʹ���������
	   //���ܣ��ж������ַ����������Ƿ����
	   System.out.println(s1.equals(s2));
	   System.out.println(s3==s4);
	   System.out.println(s3.equals(s4));
	   System.out.println(s2.equals(s3));
	   System.out.println(s2==s3);
   }
}
