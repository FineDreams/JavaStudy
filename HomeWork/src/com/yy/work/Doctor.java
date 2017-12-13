package com.yy.work;

public class Doctor extends Person  implements UserInter {

	
	
	public Doctor() {
		super();
	}

	public Doctor(String name, String username, String password, String job) {
		super(name, username, password, job);
	}

	@Override
	public void onLine() {
		System.out.println("医生开始做手术了");
		operation();
	}

	@Override
	public void offLine() {
		System.out.println("手术结束了，很成功");
	}
	
	
	public void operation(){
		System.out.println("正在手术.Loading");
	}

}