package com.yy.bookstore.user.service.exception;

public class UserNameAlreadyExistException  extends UserException{
    @Override
    public String getMessage() {
        return "用户名已存在!";
    }
}
