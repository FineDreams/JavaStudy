package com.yy.service.exception;

public class UserNameExitException extends UserException {


    @Override
    public String getMessage() {
        return "用户名已存在!";
    }
}
