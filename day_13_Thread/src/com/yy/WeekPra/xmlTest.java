package com.yy.WeekPra;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class xmlTest {
    public static void main(String[] args) throws IOException {
        Document document= DocumentHelper.createDocument();
        Element users=document.addElement("Users");

        Element person=users.addElement("Person");
        person.addAttribute("用户名","name");
        person.addText("张三");

        Element age=person.addElement("Age");
        age.addAttribute("年龄","age");
        age.addText("23");

        Element score=age.addElement("score");
        score.addText("100");

        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");

        XMLWriter xmlWriter=new XMLWriter(new FileWriter("src/output.xml"),outputFormat);
        xmlWriter.write(users);
        xmlWriter.close();
    }
}
class LoginDemo{
    public void login(){

    }
}
class Person{
    private String name;
    private String username;
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Person(String name, String username, String passWord, int age) {
        this.name = name;
        this.username = username;
        this.passWord = passWord;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

}
