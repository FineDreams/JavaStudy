package com.yy.bookstore.admin.service.exception;

public class DeleteFailedException extends OperateException{
    @Override
    public String getMessage() {
        return "删除失败，请重新操作!";
    }
}
