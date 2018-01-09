package com.yy.bookstore.user.service.exception;

public class EmailAlreadyExistException  extends UserException{
    @Override
    public String getMessage() {
        return "邮箱已被注册!";
    }
}
