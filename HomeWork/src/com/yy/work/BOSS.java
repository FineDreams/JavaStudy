package com.yy.work;

public class BOSS extends Person implements UserInter {

	
	public BOSS() {
		super();
	}

	public BOSS(String name, String username, String password, String job) {
		super(name, username, password, job);
	}

	@Override
	public void onLine() {
		System.out.println("老板开始视察工作");
		
		this.addMoney();
	}

	@Override
	public void offLine() {
		System.out.println("老板下班了");
	}
	
	public void addMoney(){
		System.out.println("老板发工资了");
	}

	
	
	
	
	
	
	
	
	
}