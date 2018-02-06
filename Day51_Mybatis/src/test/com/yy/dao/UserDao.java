package com.yy.dao;

import com.yy.domain.User;

import java.util.List;

public interface UserDao {
    User findUserById(int id);
    List<User> findUsersByName(String username);
    void insertUser(User user);
}
