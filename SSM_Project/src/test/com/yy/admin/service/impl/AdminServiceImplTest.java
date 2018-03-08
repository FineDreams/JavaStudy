package com.yy.admin.service.impl;

import com.yy.admin.dao.AdminMapper;
import com.yy.admin.domain.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class AdminServiceImplTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-servlet.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void name() throws Exception {
        AdminMapper adminMapper = (AdminMapper) context.getBean("adminMapper");
        Admin admin = adminMapper.selectByPrimaryKey(5000);
        System.out.println(admin);
    }
}