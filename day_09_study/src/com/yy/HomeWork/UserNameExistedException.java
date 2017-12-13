package com.yy.HomeWork;

public class UserNameExistedException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名已存在!";
    }
}
