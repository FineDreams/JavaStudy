package com.yy.jdkproxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestJdkProxy implements InvocationHandler {
    private Object target;
    private TestJdkTransaction testJdkTransaction;

    public TestJdkProxy(Object target, TestJdkTransaction testJdkTransaction) {
        this.target = target;
        this.testJdkTransaction = testJdkTransaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        testJdkTransaction.begin();

        method.invoke(target,args);

        testJdkTransaction.commit();

        return null;
    }
}
