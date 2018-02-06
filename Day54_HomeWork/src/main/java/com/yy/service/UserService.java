package com.yy.service;

import com.yy.domain.User;
import com.yy.service.exception.PasswordErrorException;
import com.yy.service.exception.UserNameErrorException;

public interface UserService {
    void add(User user);

    User login(User user) throws UserNameErrorException, PasswordErrorException;
}
