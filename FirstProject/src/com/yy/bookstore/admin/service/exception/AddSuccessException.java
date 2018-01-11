package com.yy.bookstore.admin.service.exception;

public class AddSuccessException  extends OperateException{
    @Override
    public String getMessage() {
        return "添加成功!";
    }
}
