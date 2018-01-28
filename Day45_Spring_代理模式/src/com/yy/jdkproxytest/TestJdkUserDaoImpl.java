package com.yy.jdkproxytest;

public class TestJdkUserDaoImpl  implements TestJdkUserDao{
    @Override
    public void add() {
        System.out.println("----add----");
    }

    @Override
    public void delete() {
        System.out.println("----delete----");
    }
}
