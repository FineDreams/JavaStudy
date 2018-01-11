package com.yy.bookstore.admin.service.exception;

public class AddFailedException  extends OperateException{
    @Override
    public String getMessage() {
        return "添加失败，请重新添加!";
    }
}
