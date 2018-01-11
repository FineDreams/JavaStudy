package com.yy.HomeWork;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserXml {
    File file=new File("src/output.xml");
    public static void putXml(Person person) throws IOException {
//        List<Person> list = UserData.getList();
//        SAXReader saxReader

        Document document=DocumentHelper.createDocument();
        if (document.getRootElement()!=null){
//            document=saxReader.read(fi);
        }else{
            document.addElement("User");

        }

        Element element=document.addElement("User");
        element.addText("用户");

        Element person1 = element.addElement("Person");
        person1.addAttribute("Name",person.getName());

        Element name = person1.addElement("UserName");
        name.addText(person.getUsername());

        Element passWord = person1.addElement("PassWord");
        passWord.addText(person.getPassword());

        Element job = person1.addElement("Job");
        job.addText(person.getJob());

        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");


        XMLWriter xmlWriter=new XMLWriter(new FileWriter("src/output.xml"),outputFormat);
        xmlWriter.write(element);

        xmlWriter.close();

        }

    }

