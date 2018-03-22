package com.yy.oneproxy;

public class RealImpl implements Real {
    @Override
    public void add() {
        System.out.println("add=====");
    }

    @Override
    public void delete() {
        System.out.println("delete======");
    }
}
