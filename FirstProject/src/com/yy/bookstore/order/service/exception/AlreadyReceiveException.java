package com.yy.bookstore.order.service.exception;

import com.yy.bookstore.order.service.exception.OrderException;

public class AlreadyReceiveException  extends OrderException{
    @Override
    public String getMessage() {
        return "付款成功!";
    }
}
