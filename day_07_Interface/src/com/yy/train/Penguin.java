package com.yy.train;

public class Penguin extends Pet{
   private String sex;

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}
public void showPet(){
	System.out.println("我的名字叫"+Pet.name+",健康值是"+getHealth()
	   +"和主人的亲密度是"+getIntimacy()+"性别是"+sex);
}
}
