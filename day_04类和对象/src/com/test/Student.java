package com.test;

public class Student {
	
	//��������������
	//�������������Ի�û��ֵ
    String name;
    String school;
    String id;
    
    public void play(){
    	System.out.println(name+"����Ϸȥ��");
    }
    public void goToStudy(){
    	System.out.println(name+"ȥ��ѧ�ˣ�ѧУ��"+school);
    }
    
    /*
     * public         Ȩ�����η�
     * void           ����ֵ����
     *              void��ʾ��û�з���ֵ
     * show           ������
     * (String str)   �����б�
     * {}             �����壺
     *                      ���������������ʱ��Ҫִ�еĴ���
     */
    public void show(String str){
    	this.name=name;
    	this.school=school;
    	
    }
    public void buyFood(int money){
    	System.out.println("������ʦ��"+money+"��Ǯȥ����Ϸ����");
    }
    public void add(int a,int b){
    	int sum=a+b;
    	System.out.println("��Ϊ:"+sum);
    }
    
    //public��������String
    //��ʾ����ֵ��������String,���ַ���
    public String hot(String food){
    	return "�����˵�"+food;
    }
}
