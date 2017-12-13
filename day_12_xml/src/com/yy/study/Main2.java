package com.yy.study;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main2 {
    static SAXReader saxReader=new SAXReader();
    static Document document = null;
    public static void main(String[] args) throws DocumentException {
//        listElements();
        document=saxReader.read(new File("src/data.xml"));
//        allEles(document.getRootElement());

        List<Student> students=listElements();
        System.out.println(Arrays.toString(students.toArray()));

    }

//    public static void  allEles(Element e){
//        List<Attribute> attributes=e.attributes();
//
//        for (int i = 0; i <attributes.size() ; i++) {
//            Attribute attr=attributes.get(i);
//            System.out.println("属性名为:"+attr.getName()+",属性值为:"+attr.getValue());
//        }
//        String text = e.getText();
//        System.out.println("当前元素的文本为:"+text);
//
//        List<Element> elements=e.elements();
////        如果没有子标签，则结束这个方法
//        if (elements.size()==0){
//            return;
//        }
//        for (int i = 0; i <elements.size() ; i++) {
//            //获得第i个子标签
//            Element element = elements.get(i);
//            //扔到allEles这个方法中
//            allEles(element);
//        }
//    }


    private static List<Student> listElements() throws DocumentException {

        Element root = document.getRootElement();
        List<Element> student = root.elements("student");

        List<Student> studentData=new ArrayList<>();

        for (int i = 0; i <student.size() ; i++) {
            Element element = student.get(i);
            Student stu=new Student();
            Attribute name = element.attribute("name");

            //获得name实行的值
            String value = name.getValue();
            //设置到stu这个对象中
            stu.setName(value);
            Element score = element.element("score");
            //拿到score标签中的文本
            String text = score.getText();
            //"1001"--->1001
            stu.setScore(Integer.parseInt(text));

            //把数据健全的学生对象，装进集合中
            studentData.add(stu);

            System.out.println("学生姓名:"+value+"分数:"+text);
        }
        return studentData;
    }

}
