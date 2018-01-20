package com.yy.user.service.exception;

public class PassWordErrorException extends UserException {
    @Override
    public String getMessage() {
        return "密码错误!";
    }
}
