package com.yy.crm.staff.service.exception;

public class UserNoExitException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在!";
    }
}
