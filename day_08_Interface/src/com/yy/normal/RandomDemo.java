package com.yy.normal;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		//ȡһ�������
		//��Ҫ�õ�Random���������
		Random random=new Random();
		
		int r=random.nextInt();
		System.out.println(r);
		
		
		//1��ȥһ��0-10֮��������
		
		//nextInt(bound)���յĲ���
		//��һ������ҿ�������[0,bound)
		int e=random.nextInt(11);
		System.out.println(e);
		
		//2��ȡһ��30-45֮��������
		//��ʽ��(���ֵ-��Сֵ+1)+��Сֵ
		int ee=random.nextInt(45-30+1)+30;
		System.out.println(ee);
		
		//3�����ȡһ��true��false
		boolean b=random.nextBoolean();
		System.out.println(b);
	}

}
