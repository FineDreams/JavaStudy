package com.yy.study;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DocumentException {
        //用来帮助我们将.xml文件弄到java世界中来的一个工具类
        SAXReader  saxReader=new SAXReader();

        //File:文件
        //括号中的字符串，是要找到哪个文件，就填入哪个文件的路径
        Document document = saxReader.read(new File("src/data.xml"));

        //获得它的document对象后，接着获取它的根节点
        //获得文档的根节点就是data.xml中的<students>标签
        Element root = document.getRootElement();

//        获取某节点的单个节点
        Element student = root.element("student");
        List elements = root.elements();


        //获得<student>标签下的name属性
        Attribute name = student.attribute("name");

        //获得name属性的值
        String value = name.getValue();
        System.out.println(value);
    }
}
