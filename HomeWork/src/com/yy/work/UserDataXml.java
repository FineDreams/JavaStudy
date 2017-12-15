package com.yy.work;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class UserDataXml {
	//将数据存入到XML文档中
	static File file=new File("src/com/yy/work/output.xml");
	public static void inputXml(Person person) throws IOException, DocumentException, UserNameExistsException {
		Document document=DocumentHelper.createDocument();
		Element element=null;
		SAXReader saxReader=new SAXReader();
		if(file.exists()) {
			document=saxReader.read(file);
			element=document.getRootElement();
		}else {
			element=document.addElement("User");
		}
//		element.addText("用户");
		Element person1 = element.addElement("Person");
		person1.addAttribute("Name",person.getName());

		Element name = person1.addElement("UserName");
		if (person.getUsername().equals(name.getText())){
			throw new UserNameExistsException();
		}else {
			name.addText(person.getUsername());
			Element passWord = person1.addElement("PassWord");
			passWord.addText(person.getPassword());
			Element job = person1.addElement("Job");
			job.addText(person.getJob());
		}
		OutputFormat outputFormat=OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("UTF-8");
		XMLWriter xmlWriter=new XMLWriter(new FileWriter(file),outputFormat);
		xmlWriter.write(element);
		xmlWriter.close();
	}

	//登录方法
	public static UserInter outPutXml(String userName,String passWord) throws DocumentException, UserNoneException, NmPdNoneException {
		SAXReader saxReader=new SAXReader();
		UserInter temp=null;
		Document read = saxReader.read(file);
		Element rootElement = read.getRootElement();
		List<Element> lists = rootElement.elements("Person");
		for (int i = 0; i <lists.size() ; i++) {
			Element element = lists.get(i);
			String name = element.attribute("Name").getValue();
			String username=element.element("UserName").getText();
			String password=element.element("PassWord").getText();
			String job=element.element("Job").getText();
			if (username.equals(userName)&&password.equals(passWord)){
				System.out.println("登录成功!");
				switch (job){
					case "Worker":
						temp=new Worker(name,username,password,job);
						break;
					case "Doctor":
						temp=new Doctor(name,username,password,job);
						break;
					case "Cooker":
						temp=new Cooker(name,username,password,job);
						break;
					case "BOSS":
						temp=new BOSS(name,username,password,job);
						break;
				}
				return temp;
			}else if (username.equals(userName)){
				throw new NmPdNoneException();
			}
		}
		throw new UserNoneException();
	}
	//注销方法
	public static void logOut() throws DocumentException, IOException, NmPdNoneException, LogOutFaildException {
		SAXReader saxReader=new SAXReader();
		Document read = saxReader.read(file);
		Element rootElement = read.getRootElement();
		Element person = rootElement.element("Person");
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入用户名:");
		String userName=scanner.nextLine();
		System.out.println("请输入密码:");
		String passWord=scanner.nextLine();

		List<Element> lists = rootElement.elements("Person");
		for (int i = 0; i <lists.size() ; i++) {
			Element element = lists.get(i);
			String username = element.element("UserName").getText();
			String password = element.element("PassWord").getText();
			if (username.equals(userName)&&password.equals(passWord)){

				rootElement.remove(person);
				break;
			}else if (username.equals(userName)) {
				throw new NmPdNoneException();
			}else {
				throw new LogOutFaildException();
			}
		}


		OutputFormat outputFormat=OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("UTF-8");
		XMLWriter xmlWriter=new XMLWriter(new FileWriter(file),outputFormat);
		xmlWriter.write(rootElement);
		xmlWriter.close();

	}
}
