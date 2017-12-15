package com.yy.exception;

public class IrregularException extends Exception {
    @Override
    public String getMessage() {
        return "用户名不规范!";
    }
}
