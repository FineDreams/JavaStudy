package com.yy.homework;

public class Worker extends Person{
    private String name;
    private double wages;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWages() {
		return wages;
	}
	public void setWages(double wages) {
		this.wages = wages;
	}
    public void Working(){
    	System.out.println("�ҵ�������:"+name+"  �ҵĹ�����:"+wages);
    }
}
