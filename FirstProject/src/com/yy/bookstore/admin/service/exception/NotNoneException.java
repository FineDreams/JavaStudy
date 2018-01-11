package com.yy.bookstore.admin.service.exception;

public class NotNoneException extends OperateException {
    @Override
    public String getMessage() {
        return "不能为空";
    }
}
