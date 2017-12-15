package com.yy.function;

import com.yy.exception.IrregularException;
import com.yy.exception.UserNameExistsException;
import com.yy.entity.Person;
import com.yy.exception.UserNameNoneException;
import com.yy.exception.passWordErroException;
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
    //注册方法
    static File file=new File("src/com/yy/entity/user.xml");
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
            if (!(password.matches("([A-Za-z0-9])+"))){
                System.out.println("密码中必须包含字母和数字!");
            }else {
                person=new Person(nickname,username,password);
                reverseToXml(person);
                System.out.println("注册成功!");
                return;
            }
        }
    }

    //将信息转化为xml
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
    //登录方法
    public static Person userLogin(String username,String password) throws DocumentException, IOException, passWordErroException, UserNameNoneException {
        Person person=null;
        SAXReader saxReader=new SAXReader();
        Boolean temp=false;
        Scanner scanner=new Scanner(System.in);
        Document document=saxReader.read(file);
        Element root=document.getRootElement();
        List<Element> lists = root.elements("Person");
        for (int i = 0; i <lists.size() ; i++) {
            Element element = lists.get(i);
            Element userName = element.element("UserName");
            String um = userName.getText();
                Element passWord = element.element("PassWord");
                String pw = passWord.getText();
                Attribute nickName = element.attribute("nickName");
                String nickname = nickName.getValue();
                if ((um.equals(username))&&(pw.equals(password))){
                    System.out.println("登录成功!");
                    person=new Person(um,pw,nickname);
                    return person;
                }else if (um.equals(username)){
                    throw new passWordErroException();
                }
            }
                throw new UserNameNoneException();
    }

    public static void Login(Person person) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (person != null) {
                System.out.print("欢迎光临!\n用户:" + person.getName());
                System.out.println("请输入要操作的功能!\n①查询天气\n②查询手机归属地\n③手速游戏\n④查询手速游戏前十名用户\n⑤返回");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        SearchDemo.searchWeather();
                        break;
                    case 2:
                        SearchDemo.searchPhone();
                        break;
                    case 3:
                        StartGame.playGame(person.getName());
                        break;
                    case 4:
                        SearchDemo.searchTen();
                        break;
                    case 5:
                        return;
                }
            }
        }
    }
}
