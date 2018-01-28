package com.yy.scope;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ScopeTest {

    private ApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context=new ClassPathXmlApplicationContext("spring-config.xml");
    }
    @Test
    //懒加载，只有需要对象时去调用getBean时才会创建对象
    //这里的对象是去Spring框架中取出的，只创建了一个
    public void lazy() throws Exception{
        context.getBean("car");
        context.getBean("car");
        context.getBean("car");
        context.getBean("car");
    }

    @Test
    public void prototype() throws Exception{
        context.getBean("stu,yyy");
        context.getBean("student");
        context.getBean("student2");
        context.getBean("stu,yyy");
        context.getBean("xxx");
//        yy报错
        context.getBean("yyy");
    }

}