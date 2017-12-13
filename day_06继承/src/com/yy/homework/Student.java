package com.yy.homework;

public class Student extends Person{
    private String name;
    private String job;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
    public void study(){
    	System.out.println("我的名字是:"+name+"我还是个"+job);
    }
}
