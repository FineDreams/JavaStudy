package com.yy.bookstore.admin.service.exception;

public class AdminPasswordErrorException extends OperateException{
    @Override
    public String getMessage() {
        return "密码错误!";
    }
}
