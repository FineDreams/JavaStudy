package com.yy.train;

public class Dog extends Pet{
	private String type;
    public void showPet(){
    	System.out.println("�ҵ����ֽ�"+Pet.name+",����ֵ��"+getHealth()
 			   +",�����˵����ܶ���"+getIntimacy()+"����Ʒ��"+type);
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
