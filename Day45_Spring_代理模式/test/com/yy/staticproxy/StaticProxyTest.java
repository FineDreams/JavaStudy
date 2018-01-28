package com.yy.staticproxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaticProxyTest {
    @Test
    public void staticProxy() throws Exception{
        UserDao userDao=new UserDaoImpl();
        Transaction transaction=new Transaction();
        UserDaoProxy daoProxy=new UserDaoProxy(transaction,userDao);
        daoProxy.add();
        daoProxy.delete();

    }
}