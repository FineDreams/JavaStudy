package com.yy.study;

public class Dog {
	/*
	 * ���췽��������:
	 * ��������ͬ�����췽���ķ���������������
	 * �����б�ͬ
	 *      �����ĸ��������������ͣ�������˳��
	 *      ���������أ�ֻҪ��һ����ͬ���ǲ����б���ǲ�ͬ��
	 */
	
	
    public Dog(){
    	System.out.println("����Ĭ�ϵĿղεĹ��췽��");
    }  
    public Dog(String name){
    	System.out.println("���Ǵ������Ĺ��췽����������name,ֵΪ:"+name);
    }
    public Dog(String name,int age){
    	System.out.println("���Ǵ������Ĺ��췽����������name,ֵΪ:"+name+"  ����ageֵΪ:"+age);
    }
    public Dog(int age,String name){
    	System.out.println("���Ǵ������Ĺ��췽����������age,ֵΪ:"+age+"  ����nameֵΪ:"+name);
    }
    
    /*
     * ���������ص�����
     *    ��������ͬ�������б�ͬ
     *    �뷵��ֵ��Ȩ�����η��޹�
     *      
     */
    public void eatBone(){
    	System.out.println("����Ϊ���ڿй�ͷ");
    }
    public String eatBone(String  n){
    	return n;
    }
}
