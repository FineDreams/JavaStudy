package com.ty.user.service;

import com.ty.user.domain.User;

public interface UserService {
    User queryUserByName(String username);
}
