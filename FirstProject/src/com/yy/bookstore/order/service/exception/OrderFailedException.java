package com.yy.bookstore.order.service.exception;

public class OrderFailedException  extends OrderException{
    @Override
    public String getMessage() {
        return "订单确认失败，你不是好人!";
    }
}
