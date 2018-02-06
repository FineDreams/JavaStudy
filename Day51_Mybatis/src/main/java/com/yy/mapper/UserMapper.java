package com.yy.mapper;

import com.yy.domain.User;

import java.util.List;

public interface UserMapper {
    public User searchUserById(int id);
    public List<User> searchUsersByName(String username);
    public void insert(User user);

}
