package com.yy.bookstore.order.service;

import com.yy.bookstore.order.dao.OrderDao;
import com.yy.bookstore.order.domain.Order;
import com.yy.bookstore.order.service.exception.AlreadySendException;
import com.yy.bookstore.order.service.exception.OrderFailedException;
import com.yy.bookstore.order.service.exception.AlreadyReceiveException;
import com.yy.bookstore.order.service.exception.SendSuccessException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public List<Order> add(Order order){
        List<Order> orderList=new ArrayList<>();
        orderList.add(order);
        return orderList;
    }
    public List<Order> getOrder(String uid){
        OrderDao orderDao=new OrderDao();
        List<Order> orders = orderDao.queryByUid(uid);
        return orders;
    }

    public void confirm(String oid) throws OrderFailedException, SQLException, AlreadyReceiveException, AlreadySendException, SendSuccessException {
        OrderDao orderDao=new OrderDao();
//        int stateByOid = orderDao.getStateByOid(oid);
        Order order = orderDao.queryByOidFromOds(oid);
        int orderState = order.getState();
        if (orderState==3){
            orderDao.updateState(oid,4);
            throw new AlreadyReceiveException();
        }
        if (orderState==4){
            orderDao.updateState(oid,5);
            throw new AlreadySendException();
        }
        if (orderState==5){
            orderDao.updateState(oid,6);
            throw new SendSuccessException();
        }
        throw new OrderFailedException();
    }

}
