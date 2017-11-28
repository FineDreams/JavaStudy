package com.yy.training;

public class DesignPattern {
    public static void main(String[] args){
    	Teacher javaTeacher=new JavaTeacher();
    	javaTeacher.Teaching();
    	System.out.println();
    	
    	Teacher phpTeacher=new PhpTeacher();
    	phpTeacher.Teaching();
    }
}
abstract class Teacher{
	public  void Teaching() {
		OpenComputer();
		Teach();
		Close();
	}

	public abstract void OpenComputer();
	public abstract void Teach();
	public abstract void Close();
}
class JavaTeacher extends Teacher{

	@Override
	public void OpenComputer() {
     System.out.println("打开电脑");
	}
	@Override
	public void Teach() {
     System.out.println("开始讲Java");
	}
	@Override
	public void Close() {
     System.out.println("讲课结束，关电脑");
	}
}
class PhpTeacher extends Teacher{

	@Override
	public void OpenComputer() {
		System.out.println("打开电脑");
	}

	@Override
	public void Teach() {
		 System.out.println("开始讲Php");
	}

	@Override
	public void Close() {
		System.out.println("讲课结束，关电脑");
	}
	
}