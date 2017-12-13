package com.yy.normal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDemo {
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));
		System.out.println(new CalendarDemo());
		
		
		long l=System.currentTimeMillis();
		
		//这个类可以帮助我们将毫秒的时间
		//转换成我们能看懂的字符串
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=df.format(l);
		System.out.println(time); 
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "我调用了这个类的toString方法";
//	}
	
}
