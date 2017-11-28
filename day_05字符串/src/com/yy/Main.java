package com.yy;

public class Main {
    public static void main(String[] args) {
		Student s=new Student();
//        s.setName("天山童姥");
        String name=s.getName();
        System.out.println("改之前:"+name);
        
        
        //当执行setName方法时，就将字符串传给了name
        s.setName("她师妹");
        name=s.getName();
        System.out.println("改之后:"+name);
		
		//得到sad方法执行的结果
		//把这个结果赋值给了result这个变量
		String result=s.sad();
		System.out.println(result);
    }
}