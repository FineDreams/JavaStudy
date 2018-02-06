package com.yy.service.exception;

public class UserNameErrorException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名错误！";
    }
}
