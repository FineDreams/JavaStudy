package com.yy.lifecycle;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class LifeTest {


    private ApplicationContext context;
//    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {

        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }
    @Test
    public void life() throws Exception{
        Object per = context.getBean("per");
//        context.close();
        ((ClassPathXmlApplicationContext) context).close();
    }

}