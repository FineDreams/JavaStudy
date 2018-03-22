package com.ty.user.service.impl;

import com.ty.user.dao.UserMapper;
import com.ty.user.domain.User;
import com.ty.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUserByName(String username) {
        User user=userMapper.selectUserByName(username);
        return user;
    }
}
