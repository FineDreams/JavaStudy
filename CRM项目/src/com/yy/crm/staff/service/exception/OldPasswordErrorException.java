package com.yy.crm.staff.service.exception;

public class OldPasswordErrorException extends EditPasswordException {
    @Override
    public String getMessage() {
        return "原始密码错误!";
    }
}
