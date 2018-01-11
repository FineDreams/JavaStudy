package com.yy.bookstore.order.service;

import com.yy.bookstore.order.dao.OrderDao;
import com.yy.bookstore.order.domain.Order;
import com.yy.bookstore.order.service.exception.OrderFailedException;
import com.yy.bookstore.order.service.exception.AlreadyReceiveException;

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

    public void confirm(String oid) throws OrderFailedException, SQLException, AlreadyReceiveException {
        OrderDao orderDao=new OrderDao();
//        int stateByOid = orderDao.getStateByOid(oid);
        Order order = orderDao.queryByOidFromOds(oid);
        int orderState = order.getState();
        if (orderState!=3){
            throw new OrderFailedException();
        }
        orderDao.updateState(oid,4);
        throw new AlreadyReceiveException();
    }

}
