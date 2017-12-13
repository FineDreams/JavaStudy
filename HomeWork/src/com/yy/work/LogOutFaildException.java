package com.yy.work;

public class LogOutFaildException extends Exception{
    @Override
    public String getMessage() {
        return "注销失败，请重试!";
    }
}
