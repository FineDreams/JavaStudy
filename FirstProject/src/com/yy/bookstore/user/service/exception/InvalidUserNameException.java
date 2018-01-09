package com.yy.bookstore.user.service.exception;

public class InvalidUserNameException extends UserException {
    @Override
    public String getMessage() {
        return "用户名无效!";
    }
}
