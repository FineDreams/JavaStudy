package com.yy.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {
     public static void main(String[] args) throws UnsupportedEncodingException {
		String a="     abcdefg   ";
		
		//去除字符串前后的空格
		//并不会把a改变，只是返回结果
		//所以这里我们将结果赋值给a
		a=a.trim();
		System.out.println(a);
		
		
		//获取字符串长度
		System.out.println(a.length());
		
		//替换，把a替换成h
		//只是返回替换的结果，并不会把结果
		//赋值给a
		System.out.println(a.replace("ab", "he"));
		
		//截取字符串中的字串
		//从0位置开始，取到1
		//这是一个左闭右开的区间
		//[0,2)所以就是从0取到1
		System.out.println(a.substring(0, 2));
		
		//取字符串中的字串
		//从3开始一直取到末尾
		System.out.println(a.substring(3));
		
		//分割字符串
		//会得到一个字符串数组
		System.out.println(Arrays.toString(a.split("e")));
		
		boolean result=a.equals("bcd");
		System.out.println(result);
		
		//判断两个字符串的内容是否相等并且忽略大小写
		boolean result2=a.equalsIgnoreCase("ABCDEFG");
		System.out.println(result2);
		
		//获取第一个字符c在a这个字符串中的位置
		//如果不存在c,则返回-1
		int index=a.indexOf('c');
		System.out.println(index);
		
		//获取index位置的字符
		//输入的index数值一定要在字符串长度内
		//否则会报错
		char ch=a.charAt(3);
		System.out.println(ch);
		
		//是否以a开头，返回Boolean的true或false
		boolean aa=a.startsWith("a");
		//是否以a结尾
		a.endsWith("a");
		
		//将字符串拼接到a后面
		a=a.concat("我是后连上的");
		System.out.println(a);
		
		//是否包含abc
		boolean t=a.contains("abc");
		System.out.println(t);
		
		//将字符串a中的小写字母都转换成大写
		a.toUpperCase();
		//将字符串a中的大写字母都转换成小写
		a.toLowerCase();
		
		//得到a字符串的字符数组
		char[] chs=a.toCharArray();
		System.out.println(
				chs
//				Arrays.toString(chs)
				);
		
		//涉及到编码转换的
		//得到a字符串的字节数组
		byte[] bytes=a.getBytes();
		
		String cs=new String(bytes,"gbk");
		System.out.println(cs);
		
	}
}
