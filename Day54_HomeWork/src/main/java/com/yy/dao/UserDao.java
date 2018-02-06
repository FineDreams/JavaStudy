package com.yy.dao;

import com.yy.domain.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> login(String username);
}
