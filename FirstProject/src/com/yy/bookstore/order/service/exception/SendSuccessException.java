package com.yy.bookstore.order.service.exception;

public class SendSuccessException extends  OrderException{
    @Override
    public String getMessage() {
        return "订单完成!";
    }
}
