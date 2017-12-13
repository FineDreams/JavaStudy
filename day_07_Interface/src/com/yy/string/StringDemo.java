package com.yy.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {
     public static void main(String[] args) throws UnsupportedEncodingException {
		String a="     abcdefg   ";
		
		//ȥ���ַ���ǰ��Ŀո�
		//�������a�ı䣬ֻ�Ƿ��ؽ��
		//�����������ǽ������ֵ��a
		a=a.trim();
		System.out.println(a);
		
		
		//��ȡ�ַ�������
		System.out.println(a.length());
		
		//�滻����a�滻��h
		//ֻ�Ƿ����滻�Ľ����������ѽ��
		//��ֵ��a
		System.out.println(a.replace("ab", "he"));
		
		//��ȡ�ַ����е��ִ�
		//��0λ�ÿ�ʼ��ȡ��1
		//����һ������ҿ�������
		//[0,2)���Ծ��Ǵ�0ȡ��1
		System.out.println(a.substring(0, 2));
		
		//ȡ�ַ����е��ִ�
		//��3��ʼһֱȡ��ĩβ
		System.out.println(a.substring(3));
		
		//�ָ��ַ���
		//��õ�һ���ַ�������
		System.out.println(Arrays.toString(a.split("e")));
		
		boolean result=a.equals("bcd");
		System.out.println(result);
		
		//�ж������ַ����������Ƿ���Ȳ��Һ��Դ�Сд
		boolean result2=a.equalsIgnoreCase("ABCDEFG");
		System.out.println(result2);
		
		//��ȡ��һ���ַ�c��a����ַ����е�λ��
		//���������c,�򷵻�-1
		int index=a.indexOf('c');
		System.out.println(index);
		
		//��ȡindexλ�õ��ַ�
		//�����index��ֵһ��Ҫ���ַ���������
		//����ᱨ��
		char ch=a.charAt(3);
		System.out.println(ch);
		
		//�Ƿ���a��ͷ������Boolean��true��false
		boolean aa=a.startsWith("a");
		//�Ƿ���a��β
		a.endsWith("a");
		
		//���ַ���ƴ�ӵ�a����
		a=a.concat("���Ǻ����ϵ�");
		System.out.println(a);
		
		//�Ƿ����abc
		boolean t=a.contains("abc");
		System.out.println(t);
		
		//���ַ���a�е�Сд��ĸ��ת���ɴ�д
		a.toUpperCase();
		//���ַ���a�еĴ�д��ĸ��ת����Сд
		a.toLowerCase();
		
		//�õ�a�ַ������ַ�����
		char[] chs=a.toCharArray();
		System.out.println(
				chs
//				Arrays.toString(chs)
				);
		
		//�漰������ת����
		//�õ�a�ַ������ֽ�����
		byte[] bytes=a.getBytes();
		
		String cs=new String(bytes,"gbk");
		System.out.println(cs);
		
	}
}
