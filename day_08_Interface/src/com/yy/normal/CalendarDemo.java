package com.yy.normal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDemo {
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));
		System.out.println(new CalendarDemo());
		
		
		long l=System.currentTimeMillis();
		
		//�������԰������ǽ������ʱ��
		//ת���������ܿ������ַ���
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=df.format(l);
		System.out.println(time); 
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "�ҵ�����������toString����";
//	}
	
}
