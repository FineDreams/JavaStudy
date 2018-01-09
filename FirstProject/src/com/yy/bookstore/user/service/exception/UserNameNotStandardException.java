package com.yy.bookstore.user.service.exception;

public class UserNameNotStandardException  extends UserException{
    @Override
    public String getMessage() {
        return "用户名不规范!";
    }
}
