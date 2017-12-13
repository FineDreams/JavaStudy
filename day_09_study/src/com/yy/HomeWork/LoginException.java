package com.yy.HomeWork;

public class LoginException extends Exception{

    @Override
    public String getMessage() {
        return "登录失败!";
    }
}
