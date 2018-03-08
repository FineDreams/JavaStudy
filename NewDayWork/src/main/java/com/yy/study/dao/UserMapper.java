package com.yy.study.dao;

import com.yy.study.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void insert(User user);
}
