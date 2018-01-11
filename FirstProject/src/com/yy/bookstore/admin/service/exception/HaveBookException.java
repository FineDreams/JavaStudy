package com.yy.bookstore.admin.service.exception;

public class HaveBookException extends OperateException{
    @Override
    public String getMessage() {
        return "该分类还有图书!";
    }
}
