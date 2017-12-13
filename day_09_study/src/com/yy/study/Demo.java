package com.yy.study;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {

        Document document=DocumentHelper.createDocument();

        Element element=document.addElement("User");
        element.addText("用户");

        Element person = element.addElement("Person");
        person.addAttribute("Name","1");

        Element name = person.addElement("UserName");
        name.addText("zh");

        Element passWord = person.addElement("PassWord");
        passWord.addText("23");

        Element job = person.addElement("Job");
        job.addText("fsd");

        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");


        XMLWriter xmlWriter=new XMLWriter(new FileWriter("src/Test.xml"),outputFormat);
        xmlWriter.write(element);

        xmlWriter.close();
    }
}
