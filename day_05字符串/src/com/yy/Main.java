package com.yy;

public class Main {
    public static void main(String[] args) {
		Student s=new Student();
//        s.setName("��ɽͯ��");
        String name=s.getName();
        System.out.println("��֮ǰ:"+name);
        
        
        //��ִ��setName����ʱ���ͽ��ַ���������name
        s.setName("��ʦ��");
        name=s.getName();
        System.out.println("��֮��:"+name);
		
		//�õ�sad����ִ�еĽ��
		//����������ֵ����result�������
		String result=s.sad();
		System.out.println(result);
    }
}