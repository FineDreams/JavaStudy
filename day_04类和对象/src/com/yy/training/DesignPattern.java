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
     System.out.println("�򿪵���");
	}
	@Override
	public void Teach() {
     System.out.println("��ʼ��Java");
	}
	@Override
	public void Close() {
     System.out.println("���ν������ص���");
	}
}
class PhpTeacher extends Teacher{

	@Override
	public void OpenComputer() {
		System.out.println("�򿪵���");
	}

	@Override
	public void Teach() {
		 System.out.println("��ʼ��Php");
	}

	@Override
	public void Close() {
		System.out.println("���ν������ص���");
	}
	
}