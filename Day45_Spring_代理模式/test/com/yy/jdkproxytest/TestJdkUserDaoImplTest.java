package com.yy.jdkproxytest;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class TestJdkUserDaoImplTest {

    @Test
    public void testJdkUserDaoImlTest(){
       TestJdkUserDao testJdkUserDao=new TestJdkUserDaoImpl();
       TestJdkTransaction testJdkTransaction=new TestJdkTransaction();

       TestJdkProxy testJdkProxy=new TestJdkProxy(testJdkUserDao,testJdkTransaction);

       Proxy.newProxyInstance(testJdkUserDao.getClass().getClassLoader(),testJdkUserDao.getClass().getInterfaces(),testJdkProxy);


    }

}