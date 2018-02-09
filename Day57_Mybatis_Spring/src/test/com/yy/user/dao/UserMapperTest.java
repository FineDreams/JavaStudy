package com.yy.user.dao;

import com.yy.user.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserMapperTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-servlet.xml");
    }

    @Test
    public void findUserByIdTest(){
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User userById = userMapper.findUserById(1);
        System.out.println(userById);
    }

}