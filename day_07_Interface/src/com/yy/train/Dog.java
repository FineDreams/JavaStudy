package com.yy.train;

public class Dog extends Pet{
	private String type;
    public void showPet(){
    	System.out.println("我的名字叫"+Pet.name+",健康值是"+getHealth()
 			   +",和主人的亲密度是"+getIntimacy()+"所属品种"+type);
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
