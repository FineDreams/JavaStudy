package com.yy.bookstore.user.service.exception;

public class UserNotActiveException  extends UserException{
    @Override
    public String getMessage() {
        return "账号未激活!";
    }
}
