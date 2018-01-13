package com.yy.bookstore.order.service.exception;

public class AlreadySendException  extends OrderException{
    @Override
    public String getMessage() {
        return "发货成功!";
    }
}
