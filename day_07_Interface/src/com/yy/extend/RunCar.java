package com.yy.extend;

public class RunCar extends Car{
    //�ܳ��ļ��٣�Ӧ�ñ�һ��Ŀ�
	//�������Ǹ�д����Car�еļ��ٷ���
	//��д�����ǰѴӸ����м̳еķ����޸�

	
	//ע��
	@Override//���ע�����������Ǽ�⣬
	         //speed�����Ƿ��ǴӸ���̳�����
	public void speed(){
		super.speed();
		System.out.println("���ٶ�Ϊ240");
	}
}
