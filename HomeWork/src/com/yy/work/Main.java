package com.yy.work;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.dom4j.DocumentException;

public class Main {
	static String username=null;
	static String password=null;
	public static void main(String[] args) {
		UserInter us=null;
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("①、注册\n②、登录\n③、注销");
			String string=scanner.nextLine();
			switch(string) {
				case "1":
					try {
						UserOperate.userRegister();
					} catch (RegisterException e) {
						System.out.println(e.getMessage());
					} catch (IOException e) {
						e.printStackTrace();
					} catch (DocumentException e) {
						e.printStackTrace();
					}
					break;
				case "2":
					receive(scanner);
					try {
						us=UserDataXml.outPutXml(username,password);
					} catch (LoginException e) {
						System.out.println(e.getMessage());
						continue;
					} catch (DocumentException e) {
						e.printStackTrace();
					}
					if(us!=null) {
						Person p=(Person)us;
						System.out.println("姓名:"+p.getName()+"\n职业:"+p.getJob()
								+"\n系统时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						System.out.println("是否开始工作？\n1、是\t2、否");
						String choice=new Scanner(System.in).nextLine();
						switch(choice) {
							case "1":
								us.onLine();
								break;
							case "2":
								us.offLine();
								break;

							default:
								System.out.println("命令错误!");
								break;
						}
					}
					break;
				case "3":
					try {
						try {
							try {
								UserDataXml.logOut();
							} catch (LogOutFaildException e) {
								System.out.println(e.getMessage());
							}
						} catch (NmPdNoneException e) {
							System.out.println(e.getMessage());
							continue;
						}
					} catch (DocumentException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
			}
		}
	}

	private static void receive(Scanner scanner) {
		System.out.println("请输入用户名:");
		username=scanner.nextLine();
		System.out.println("请输入密码:");
		password=scanner.nextLine();
	}

}
