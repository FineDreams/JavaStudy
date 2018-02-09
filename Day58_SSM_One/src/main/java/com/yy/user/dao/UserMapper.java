package com.yy.user.dao;

import com.yy.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void insertUser(User user);
    User findUserByName(String username);
}
