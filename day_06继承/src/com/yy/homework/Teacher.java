package com.yy.homework;

public class Teacher extends Person{
    private String name;
    private String hobby;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
    
	public void teach(){
		System.out.println("我的名字:"+name+"  我的爱好是:"+hobby);
	}
    
}
