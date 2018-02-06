package com.yy.mapper;

import com.yy.domain.User;

import java.util.List;

public interface UserMapper {
    User searchUserById(int id);
    List<User> searchUsersByName(String username);
    void updateUser(User user);
    void insertUser(User user);
    User findUserByIdResultMap(int id);
    List<User> findUserByNameResultMap(String username);
}
