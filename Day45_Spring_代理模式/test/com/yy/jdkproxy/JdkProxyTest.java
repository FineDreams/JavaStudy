package com.yy.jdkproxy;

import com.yy.staticproxy.UserDao;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class JdkProxyTest {
    @Test
    public void jdkTest() throws Exception{
        JdkUserDao jdkUserDao=new JdkUserDaoImpl();

        JdkTransaction jdkTransaction=new JdkTransaction();

        JdkProxy jdkProxy=new JdkProxy(
                jdkUserDao
                ,jdkTransaction
        );

        Object o = Proxy.newProxyInstance(jdkUserDao.getClass().getClassLoader()
                , jdkUserDao.getClass().getInterfaces()
                , jdkProxy);

//        UserDao userDao = (UserDao) o;
//        System.out.println(userDao);
        System.out.println(o.getClass().getName());
    }

}