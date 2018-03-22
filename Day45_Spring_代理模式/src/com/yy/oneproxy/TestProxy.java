package com.yy.oneproxy;

public class TestProxy {
    private Real real;

    private Transaction transaction;

    public TestProxy(Real real, Transaction transaction) {
        this.real = real;
        this.transaction = transaction;
    }

    public void add(){
        transaction.begin();
        real.add();
        transaction.commit();
    }
    public void delete(){
        transaction.begin();
        real.delete();
        transaction.commit();
    }
}
