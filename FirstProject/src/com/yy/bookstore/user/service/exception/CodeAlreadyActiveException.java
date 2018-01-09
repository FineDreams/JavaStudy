package com.yy.bookstore.user.service.exception;

public class CodeAlreadyActiveException extends UserException {
    @Override
    public String getMessage() {
        return "激活码已激活!";
    }
}
