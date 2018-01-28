package com.yy.cgproxytest;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCgUserDaoTest {

    private Object o;

    @Test
    public void testCgUserDao(){

        TestCgUserDao testCgUserDao=new TestCgUserDaoImpl();

        TestCgTransaction testCgTransaction=new TestCgTransaction();

        TestCgProxy testCgProxy=new TestCgProxy(testCgUserDao,testCgTransaction);

        Enhancer enhancer=new Enhancer();

        enhancer.setCallback(testCgProxy);

        enhancer.setSuperclass(testCgUserDao.getClass());

        Object o = enhancer.create();



    }

}