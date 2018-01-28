package com.yy.statictest;

public class TestProxy implements TestUserDao {
    private TestUserDao testUserDao;
    private TestTransaction testTransaction;

    public TestProxy(TestUserDao testUserDao, TestTransaction testTransaction) {
        this.testUserDao = testUserDao;
        this.testTransaction = testTransaction;
    }

    @Override
    public void add() {
        testTransaction.begin();
        testUserDao.add();
        testTransaction.commit();

    }

    @Override
    public void delete() {
        testTransaction.begin();
        testUserDao.delete();
        testTransaction.commit();
    }
}
