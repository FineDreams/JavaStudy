package com.yy.workTest1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regist {
    static File file=new File("src/com/yy/workTest1/user.xml");
    public static void getPer() throws DocumentException, UserNameExistsException, IrregularException, IOException {
        Scanner scanner = new Scanner(System.in);
        Boolean isTrue = null;
        Person person=null;
        while (true){
            System.out.println("请输入你的名字:");
            String nickname = scanner.nextLine();
            if(!(nickname.matches("[A-Za-z]*"))){
                System.out.println("昵称只能是英文字母!");
                continue;
            }
            System.out.println("请输入用户名:");
            String username = scanner.nextLine();
            isTrue = Pattern.matches("[1][3578]\\d\\d\\d\\d\\d\\d\\d\\d\\d", username);
            if ( isTrue== true) {
                if (file.exists()) {
                    SAXReader saxReader = new SAXReader();
                    Document read = saxReader.read(file);
                    Element rootElement = read.getRootElement();
                    List<Element> lists = rootElement.elements("Person");
                    for (int i = 0; i < lists.size(); i++) {
                        Element element = lists.get(i);
                        String userName = element.element("UserName").getText();
                        if (userName.equals(username)) {
                            throw new UserNameExistsException();
                        }
                    }
                }
            }else {
                throw new IrregularException();
            }
            System.out.println("请输入密码:");
            String password = scanner.nextLine();
            if (!(password.matches("[A-Za-z0-9]+"))){
                System.out.println("密码中必须包含字母和数字!");
            }else {
                person=new Person(nickname,username,password);
                reverseToXml(person);
                System.out.println("注册成功!");
                return;
            }
        }
    }


    public static void reverseToXml(Person person) throws DocumentException, UserNameExistsException, IOException {
        Document document=DocumentHelper.createDocument();
        Element root=null;
        SAXReader saxReader=new SAXReader();
        if (file.exists()){
            document=saxReader.read(file);
            root=document.getRootElement();
        }else {
            root=document.addElement("User");
        }
        Element person1 = root.addElement("Person");
        person1.addAttribute("nickName",person.getName());

        Element name = person1.addElement("UserName");
        if (person.getUsername().equals(name.getText())){
            throw new UserNameExistsException();
        }else {
            name.addText(person.getUsername());
            Element passWord = person1.addElement("PassWord");
            passWord.addText(person.getPassword());

        }
        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter=new XMLWriter(new FileWriter(file),outputFormat);
        xmlWriter.write(root);
        xmlWriter.close();
    }

    public static void userLogin(String username,String password) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Scanner scanner=new Scanner(System.in);
        Document document=saxReader.read(file);
        Element root=document.getRootElement();
        List<Element> lists = root.elements("Person");
        for (int i = 0; i <lists.size() ; i++) {
            Element element = lists.get(i);
            Attribute nickName = element.attribute("nickName");
            String nickname=nickName.getValue();
            Element userName = element.element("UserName");
            String um=userName.getText();
            Element passWord = element.element("PassWord");
            String pw=passWord.getText();

            if (um.equals(username)&&pw.equals(password)){
                System.out.println("登录成功!");
                System.out.println("欢迎光临！\t用户:"+nickname);
                System.out.println("请输入要操作的功能!\n①查询天气\n②查询手机归属地\n③手速游戏\n④查询手速游戏前十名用户");
                String input=scanner.nextLine();
                switch (input){
                    case "1":
                        try {
                            SearchDemo.searchWeather();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "2":
                        try {
                            SearchDemo.searchPhone();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "3":
                        try {
                            StartGame.playGame(nickname);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "4":

                        break;
                    default:
                        break;
                }
            return;
            }else if (um.equals(username)){
                System.out.println("密码错误!");
                return;
            }else {
                System.out.println("用户名不存在!");
                return;
            }
        }

    }
}
