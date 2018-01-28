package com.yy.cgproxytest;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCgProxyTest {

    @Test
    public void testCgProxyTest(){

        TestCgUserDao testCgUserDao=new TestCgUserDaoImpl();
        TestCgTransaction testCgTransaction=new TestCgTransaction();
        TestCgProxy testCgProxy=new TestCgProxy(testCgUserDao,testCgTransaction);
        Enhancer enhancer=new Enhancer();
        enhancer.setCallback(testCgProxy);
        enhancer.setSuperclass(testCgUserDao.getClass());

        Object o = enhancer.create();
        TestCgUserDao dao = (TestCgUserDao) o;
        dao.add();
        dao.delete();

        System.out.println(dao.getClass().getName());
        System.out.println(dao.getClass().getSuperclass().getName());

    }

}