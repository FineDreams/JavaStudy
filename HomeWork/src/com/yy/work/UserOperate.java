package com.yy.work;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class UserOperate {
	static File file=new File("src/com/yy/work/output.xml");
	public static final String WORKER="1",DOCTOR="2",COOKER="3",BOSS="4";

	public static void userRegister() throws RegisterException, IOException, DocumentException {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入姓名:");
		String name=sc.nextLine();
		System.out.println("请输入用户名:");
		String userName=sc.nextLine();
		if (file.exists()) {
			SAXReader saxReader = new SAXReader();
			Document read = saxReader.read(file);
			Element rootElement = read.getRootElement();
			List<Element> lists = rootElement.elements("Person");
			for (int i = 0; i < lists.size(); i++) {
				Element element = lists.get(i);
				String username = element.element("UserName").getText();
				if (username.equals(userName)) {
					throw new UserNameExistsException();
				}
			}
		}
		System.out.println("请输入密码:");
		String passWord=sc.nextLine();
		System.out.println("请输入工作类型:\n1、Worker\t2、Doctor\t3、Cooker\t4、BOSS");
		String job=sc.nextLine();
		Person person;
		switch(job) {
			case WORKER:
				person=new Worker(name,userName,passWord,"Worker");
				break;
			case DOCTOR:
				person=new Doctor(name,userName,passWord,"Doctor");
				break;
			case COOKER:
				person=new Cooker(name,userName,passWord,"Cooker");
				break;
			case BOSS:
				person=new BOSS(name,userName,passWord,"BOSS");
				break;
			default:
				person=null;
				break;
		}
		if(person!=null) {
			UserDataXml.inputXml(person);
			System.out.println("注册成功！");
		}
	}
}