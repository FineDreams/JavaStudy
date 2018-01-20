package com.yy.user.service.exception;

public class UserNameNoneException extends UserException {
    @Override
    public String getMessage() {
        return "用户名错误";
    }
}
