package com.yy.HomeWork;

public class UserNpaaWExistsException extends  LoginException{
    @Override
    public String getMessage() {
        return "用户名密码不匹配!";
    }
}
