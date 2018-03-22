package com.yy.oneproxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneTestProxyTest {

    @Test
    public void test(){

        Transaction transaction=new Transaction();
        Real real=new RealImpl();
        TestProxy testProxy=new TestProxy(real,transaction);
        testProxy.add();
        testProxy.delete();

    }

}