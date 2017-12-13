package com.yy.Test;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;

public class xmlPractice {
    static File file=new File("src/com/yy/test/test.xml");
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read(file);
        Element root=document.getRootElement();
        Element student1=root.element("student1");
        Element student2=root.element("student2");
        Element student3=root.element("student3");
        get(student1);
        get(student2);
        get(student3);
        try {
            set();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void get(Element student) throws DocumentException {

        String id=student.attribute("id").getValue();
        String color=student.attribute("color").getValue();


        String name=student.element("name").getText();
        String year=student.element("year").getText();
        String sex=student.element("sex").getText();

        System.out.println("id--"+id+"\tcolor--"+color+"\tname--"+name+"\tyear--"+year+"\tsex--"+sex);
    }
    public static void set() throws DocumentException, IOException {
        SAXReader saxReader=new SAXReader();
        Document document= DocumentHelper.createDocument();
        Element root=null;
        if (file.exists()){
            document=saxReader.read(file);
            root=document.getRootElement();
        }else {
            root=document.addElement("students");
        }

        Element student3=root.addElement("student3");
        student3.addAttribute("id","003");
        student3.addAttribute("color","black");

        Element name=student3.addElement("name");
        name.addText("学生3");
        Element year=student3.addElement("year");
        year.addText("23");
        Element sex=student3.addElement("sex");
        sex.addText("男");

        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");

        XMLWriter xmlWriter=new XMLWriter(new FileWriter(file),outputFormat);
        xmlWriter.write(root);
        xmlWriter.close();
    }
}
