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
	System.out.println("�ҵ����ֽ�"+Pet.name+",����ֵ��"+getHealth()
	   +"�����˵����ܶ���"+getIntimacy()+"�Ա���"+sex);
}
}
