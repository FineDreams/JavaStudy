package com.yy.homework;

public class Car {
    private String wheel;
    private String mark;
	public String getWheel() {
		return wheel;
	}
	public void setWheel(String wheel) {
		this.wheel = wheel;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public void run(){
		System.out.println("车能开动");
	}
    
    
}
