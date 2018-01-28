package com.yy.aop;


import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
//        int a=10/0;
        System.out.println("-------add-------");
    }
    public String get(){
        return "虎啸龙吟索";
    }
}
