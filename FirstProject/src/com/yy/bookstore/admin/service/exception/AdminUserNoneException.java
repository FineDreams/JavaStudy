package com.yy.bookstore.admin.service.exception;

public class AdminUserNoneException extends OperateException{
    @Override
    public String getMessage() {
        return "该管理员账户不存在";
    }
}
