package com.yy.HomeWork;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class UserOperate {
    public static final String WORKER="1";
    public static final String DOCTOR="2";
    public static final String COOKER="3";
    public static final String BOSS="4";
    public static void Register(Person person){
        UserData.getList().add(person);
    }
    public static void userRegister() throws UserNameExistedException, IOException {
        Person person;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String userName=sc.nextLine();
        Iterator<Person> iterator=UserData.getList().iterator();
        while (iterator.hasNext()){
            Person person1=iterator.next();
            if(person1.getUsername().equals(userName)){
                throw new UserNameExistedException();
            }
        }
        System.out.println("请输入姓名:");
        String name=sc.nextLine();
        System.out.println("请输入密码:");
        String passWord=sc.nextLine();
        System.out.println("请选择职业:1、Worker 2、Doctor 3、Cooker 4、BOSS");
        String job=sc.nextLine();
        switch (job){
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
                System.out.println("命令错误!");
                person=null;
                break;
        }
        if (person!=null) {
//            UserData.getList().add(person);
            UserXml.putXml(person);
            System.out.println("注册成功!");
        }
    }
        public static UserInter userLogin(String userName,String passWord) throws LoginException, DocumentException {
//            UserInter temp=null;
//            Iterator<Person> it=UserData.getList().iterator();
//            return getUserInter(userName, passWord);

            SAXReader saxReader=new SAXReader();
            Document document = saxReader.read(new File("src/output.xml"));
            Element rootElement = document.getRootElement();
//            Element person = rootElement.elements("Person");
            return null;
        }

    private static UserInter getUserInter(String userName, String passWord) throws LoginException {
        for (int i = 0; i < UserData.getList().size() ; i++) {
            Object o = UserData.getList().get(i);
            if (o instanceof Person) {
                Person person = (Person) o;
                 if ((person.getUsername().equals(userName) && (person.getPassword().equals(passWord)))) {
                    System.out.println("登录成功");
                    return person;
                }else if (!(person.getUsername().equals(userName))) {
                    throw new UserNoneException();
                } else {
                    throw new UserNpaaWExistsException();
                }
            }
        }
        throw new LoginException();
    }

}
