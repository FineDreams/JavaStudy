package com.yy.exception;

public class passWordErroException extends Exception {
    @Override
    public String getMessage() {
        return "密码错误!";
    }
}
