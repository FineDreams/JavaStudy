package com.yy.dao;

import com.yy.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findUser();
    void insertUser(User user);
}
