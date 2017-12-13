package com.yy.work;

public class Worker extends Person implements UserInter {
	
	
	

	public Worker() {
		super();
	}

	public Worker(String name, String username, String password, String job) {
		super(name, username, password, job);
	}

	@Override
	public void onLine() {
		System.out.println("工人开始工作了");
		strike();
	}

	@Override
	public void offLine() {
		System.out.println("工作完回家了");
	}
	
	public void strike(){
		System.out.println("罢工，不干了");
	}

}
