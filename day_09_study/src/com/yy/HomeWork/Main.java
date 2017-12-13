package com.yy.HomeWork;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException, DocumentException {
		boolean bln = true;
		UserInter ui=null;
		Scanner scanner = new Scanner(System.in);
		while (bln) {
			System.out.println("1、注册   2、登录");
			String choice = scanner.nextLine();
			switch (choice) {
				case "1":
					try {
						UserOperate.userRegister();
					} catch (UserNameExistedException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "2":
					System.out.println("请输入用户名:");
					String userName = scanner.nextLine();
					System.out.println("请输入密码:");
					String passWord = scanner.nextLine();
					try {
						 ui = UserOperate.userLogin(userName, passWord);

					} catch (UserNoneException e) {
						System.out.println(e.getMessage());
					} catch (UserNpaaWExistsException e) {
						System.out.println(e.getMessage());
					} catch (LoginException e) {
						e.printStackTrace();
					}
					if (ui != null) {
						Person person = (Person) ui;
						System.out.println("当前登录用户：" + person.getName() + "	职业为：" + person.getJob() +
								"   系统当前时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.format(new Date()));
						System.out.println("是否开始工作？1、是  2、否");
						int chance = new Scanner(System.in).nextInt();
						switch (chance) {
							case 1:
								person.onLine();
								break;
							case 2:
								person.offLine();
								break;
							default:
								System.out.println("没这个命令!");
								break;
						}
					}
					break;
					default:
						System.out.println("输入错误!");
						break;
			}


		}
	}

}
