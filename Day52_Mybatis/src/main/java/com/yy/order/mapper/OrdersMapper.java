package com.yy.order.mapper;

import com.yy.domain.User;
import com.yy.order.domain.Orders;
import com.yy.order.domain.OrdersExt;

import java.util.List;

public interface OrdersMapper {
    //进行订单信息查询，包括用户的名称和地址信息
    List<OrdersExt> findOrdersUser();
    List<Orders> findOrdersUserRstMap();
    List<Orders> findOrdersAndOrderdetailRstMap();
    List<User> findUserAndItemsRstMap();
}
