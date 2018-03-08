package com.yy.service.service.impl;

import com.yy.service.dao.ServiceMapper;
import com.yy.service.domain.Service;
import com.zhuang.util.VerifyCode;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceServiceImplTest {

    private ApplicationContext context;

    @org.junit.Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-servlet.xml");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void name() throws Exception {
        ServiceMapper serviceMapper = (ServiceMapper) context.getBean("serviceMapper");
        Map<String,Object> map=new HashMap<>();
        map.put("start",0);
        map.put("pageSize",5);
        List<Service> serviceList = serviceMapper.queryAllByGroup(map);
        for (Service service : serviceList) {
            System.out.println(service);
        }
    }

}