package com.yy.extend;

public class BigCar extends Car{
	//���������{}������
	//������Ա���Ի��Ա����
	//show�����ж����w
	//�оֲ�����
	//�ֲ�������ֻ�ڶ�������{}����Ч
	//���������Ч��Χ������Ϊ������������
	private String name="�󿨳�";
	
	public void pullGoods(){
//		w
		System.out.println("����ȥ��");
	}
	
    public void  show(){
    	//��Ϊwheels��˽�е�
    	//���������޷����ʣ�Ҳ���޷���ֵ
//    	wheels=4;
    	int w=getWheels();
    	System.out.println("��̥����Ϊ:"+w);
    }

	@Override
	public int getWheels() {
		return super.getWheels();
	}

	@Override
	public void setWheels(int wheels) {
		super.setWheels(wheels);
	}

	@Override
	public String getColor() {
		return super.getColor();
	}

	@Override
	public void setColor(String color) {
		System.out.println("���������е�setColor����"+color);
		super.setColor(color);
		
	}
	public void showThis(){
		/*
		 * this ���ڵ��ñ����Լ��ķ���
		 * super���ڵ��ø���ķ���
		 * this�����������
		 * ����һ��û��˵����super�и�������
		 * 
		 * this���Ե��ñ�������ԣ�����
		 */
		this.setColor("�������ú�ɫ");
		super.setColor("����������ɫ");
	}

	@Override
	public void speed() {
		// TODO Auto-generated method stub
		super.speed();
		System.out.println("���ٶ�Ϊ80");
	}
}
