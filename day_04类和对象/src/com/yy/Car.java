package com.yy;

public class Car {
	private static Car car;
	private Car(){
		System.out.println("һ��Car����");
	}
	public static synchronized Car getInstance(){
		if(car==null){
			car=new Car();
		}
		return car;
	}
	/*
	 * ��ʵ�����еĳ�
	 * ���Լ��٣����٣�ת��
	 * �г��ƺţ����������������̵ȵ�
	 * 
	 * ��java�ı�������У����ǿ��Դ���һ���࣬������Car����ʾ�����еĳ�
	 * ��ô������Ϣ�ͳ������������飬
	 * Car������ӵ��
	 * 
	 * �������복�йص����ݣ�д��Car�������
	 * ʱ�����ǾͿ���˵���ѳ��������Car�����
	 * ��Ϊ�������Ǵ��ڵ�
	 * ��Car�����Ǳ�������е���
	 */
	
	/*
	 * �����е���Ϣ---�������е�����
	 * �����еĶ���--�����еķ���
	 */
	
	//���� 
	//mark��û��ֵ�ã�û�����ݵ�
	//���ʱ��Ĺ����Ƕ���Ĺ���
	
	//���ƺ�
		private String mark;
		//������ɫ
		private String color;
		
		public void setMark(String mark){
			this.mark=mark;
		}
		public String getMark(){
			return mark;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getColor() {
			return color;
		}
		public void setCar(String mark,String color){
			this.mark=mark;
			this.color=color;
		}
		
		//showInfo����������е���Ϊ
		//���и�������࣬���������Ķ���
		//�����������Ϊ
		//��Java�У��Ͱ���Ϊ��������
		public void showInfo(){
			System.out.println("���ƺ���:"+mark+"\t"+"��ɫ��:"+color);
		}
}
