package com.yy.exception;

public class UserNameNoneException extends Exception{
    @Override
    public String getMessage() {
        return "用户名不存在!";
    }
}
