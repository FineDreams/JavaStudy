package com.yy.jdkproxytest;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class TestJdkUserDaoTest {

    @Test
    public void testJdkUserDaoTest() throws Exception{

        TestJdkUserDao testJdkUserDao=new TestJdkUserDaoImpl();

        TestJdkTransaction testJdkTransaction=new TestJdkTransaction();

        TestJdkProxy testJdkProxy=new TestJdkProxy(testJdkUserDao,testJdkTransaction);

        Object o = Proxy.newProxyInstance(testJdkUserDao.getClass().getClassLoader()
                , testJdkUserDao.getClass().getInterfaces()
                , testJdkProxy);
        System.out.println(o.getClass().getName());

    }

}