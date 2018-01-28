package com.yy.statictest;

public class TestTransactionImpl implements TestUserDao {
    @Override
    public void add() {
        System.out.println("---------add--------");
    }

    @Override
    public void delete() {
        System.out.println("--------delete------");
    }
}
