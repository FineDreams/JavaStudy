package com.yy.change;

public class Main {
     public static void main(String[] args) {
    	 //���������ָ��������Ķ���
		 Film f1=new KongFu();
		 
//		 f1=new LieChang();
		 
		 
		 //��������ã�ֻ���ҵ�����ķ���
		 //�Ҳ���������еķ���
		 f1.showFilm();
		 
		 if(f1 instanceof KongFu){
			 //���f1�������ָ��Ķ�������ΪKongFu
			 //��ô���ǿ��Խ���ǿ������ת��
			 
			 //()��д�ľ���Ҫǿת������
			 KongFu LiZhou=(KongFu) f1;
			 LiZhou.start();
		 }
	}
}
