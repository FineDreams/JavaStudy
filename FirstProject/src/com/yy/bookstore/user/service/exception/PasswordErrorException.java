package com.yy.bookstore.user.service.exception;

public class PasswordErrorException extends UserException {
    @Override
    public String getMessage() {
        return "密码错误!";
    }
}
