package com.yy.statictest;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProxyTest {

    @Test
    public void testProxyTest(){
        TestUserDao testUserDao=new TestTransactionImpl();
        TestTransaction testTransaction=new TestTransaction();

        TestProxy testProxy=new TestProxy(testUserDao,testTransaction);
        testProxy.add();

        testProxy.delete();

    }

}