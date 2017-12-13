package com.yy.WeekPra;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class TestXml {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read(new File("src/output.xml"));
        Element root=document.getRootElement();
//        System.out.println(root.remove(root.element("Person")));


//        allEles(root);
        Element person=root.element("Person");
        Attribute name=person.attribute("用户名");
        String na=name.getValue();
        System.out.println("属性为:"+name+"\t属性的值:"+na);
        Element age=person.element("Age");
        Element score=age.element("score");



    }

    public static void  allEles(Element e){
        List<Attribute> attributes=e.attributes();

        for (int i = 0; i <attributes.size() ; i++) {
            Attribute attr=attributes.get(i);
            System.out.println("属性名为:"+attr.getName()+",属性值为:"+attr.getValue());
        }
        String text = e.getText();
        System.out.println("当前元素的文本为:"+text);

        List<Element> elements=e.elements();
//        如果没有子标签，则结束这个方法
        if (elements.size()==0){
            return;
        }
        for (int i = 0; i <elements.size() ; i++) {
            //获得第i个子标签
            Element element = elements.get(i);
            //扔到allEles这个方法中
            allEles(element);
        }
    }
}
