package com.yy.study.dao;

import com.yy.study.domain.User;

public class UserDao {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void addUser(){
        System.out.println("DAO:----添加了一个User-----"+user.getName());

    }

}
