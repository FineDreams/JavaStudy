package com.yy.inter;

import com.yy.study.Doctor;
import com.yy.study.Teacher;

public class Main {
       public static void main(String[] args) {
		
    	   /*
    	    * interface:�ӿ�
    	    * class:��
    	    * 
    	    * ����������Java����һ�������
    	    * ����һ�ֲ��еĹ�ϵ
    	    * 
    	    * Java�еĽӿڣ���ʾһ���淶���߹���
    	    * �����಻��ֱ�Ӵ������󣬵��ǿ���ʹ��
    	    * ����������á�
    	    *      ����ղŽ���Person����һ��������
    	    *      Person p������һ������
    	    *      
    	    *�ӿ�Ҳ�����Ƶģ�Ҳ����ֱ�Ӵ�������
    	    *���ǿ���ʹ�ýӿڵ�����      
    	    */
    	   
    	   //�����������־���wd
    	   //��������������ģ�
    	   //���һ������û������
    	   //��ô������������
    	   WatchDog wd=new WatchDog();
    	   
    	   
    	   Company facebook=new Company();
    	   //�����work��Ҫ����ȥһ��ʲô�أ�
    	   facebook.setWork(new WatchDog());

    	   facebook.startWork();
    	   facebook.endWork();
       }
}