package com.yy.service.impl;

import com.yy.dao.UserDao;
import com.yy.domain.User;
import com.yy.service.UserService;
import com.yy.service.exception.PasswordErrorException;
import com.yy.service.exception.UserNameErrorException;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.addUser(user);
    }

    public User login(User user) throws UserNameErrorException, PasswordErrorException {

        List<User> users = userDao.login(user.getUsername());
//        User userByDB = users.get(0);
        if (users.size()==0){
            throw new UserNameErrorException();
        }
        User userByDB = users.get(0);
        if (!(user.getPassword()).equals(userByDB.getPassword())){
            throw new PasswordErrorException();
        }
        return userByDB;
    }
}
