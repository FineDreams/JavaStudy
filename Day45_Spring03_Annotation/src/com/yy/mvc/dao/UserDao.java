package com.yy.mvc.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
   private ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
   public void show(){
        Object user = context.getBean("user");
    }

}
