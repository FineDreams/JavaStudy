package com.yy.bookstore.admin.service.exception;

public class DeleteSuccessException extends OperateException{
    @Override
    public String getMessage() {
        return "删除成功!";
    }
}
