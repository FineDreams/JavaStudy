package com.yy.cgproxytest;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCgProxy implements MethodInterceptor {
    private Object target;
    private TestCgTransaction testCgTransaction;

    public TestCgProxy(Object target, TestCgTransaction testCgTransaction) {
        this.target = target;
        this.testCgTransaction = testCgTransaction;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        testCgTransaction.begin();

        method.invoke(target,objects);

        testCgTransaction.commit();

        return null;
    }
}
