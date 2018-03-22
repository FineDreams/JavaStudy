package com.yy.service;

import com.yy.domain.User;

public interface UserService {

    User selectUserByName(String username);

    void insertUser(User user);
}
