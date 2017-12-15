package com.yy.exception;

public class UserNameExistsException extends Exception{
    @Override
    public String getMessage() {
        return "用户名已存在!";
    }
}
