package com.yy.work;

public class Cooker extends Person  implements UserInter {

	public Cooker() {
		super();
	}

	public Cooker(String name, String username, String password, String job) {
		super(name, username, password, job);
	}

	@Override
	public void onLine() {
		System.out.println("厨师开始炒菜了");
		topSpoon();
	}

	@Override
	public void offLine() {
		System.out.println("菜炒完了");
	}
	
	public void topSpoon(){
		System.out.println("开始颠勺了");
	}

}