package com.yy.study.service;

import com.yy.study.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(){
        userDao.addUser();
        System.out.println("----service----");
    }

}
