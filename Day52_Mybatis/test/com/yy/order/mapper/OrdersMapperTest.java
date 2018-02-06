package com.yy.order.mapper;

import com.yy.domain.User;
import com.yy.order.domain.OrderDetail;
import com.yy.order.domain.Orders;
import com.yy.order.domain.OrdersExt;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrdersMapperTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void testFindOrdersUser(){
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersExt> list = ordersMapper.findOrdersUser();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testFindOrdersUserRstMap(){
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = ordersMapper.findOrdersUserRstMap();
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public void testFindOrdersAndOrderdetailRstMap(){
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.findOrdersAndOrderdetailRstMap();
        for (Orders orders : ordersList) {
            for (Orders orders1 : ordersList) {
                List<OrderDetail> detailList = orders1.getDetailList();
                for (OrderDetail orderDetail : detailList) {
                    System.out.println(orderDetail.toString());
                }
            }
        }
        System.out.println(ordersList);
        sqlSession.close();
    }

    @Test
    public void testFindUserAndItemsRstMap(){
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> userAndItemsRstMap = ordersMapper.findUserAndItemsRstMap();
        for (User user : userAndItemsRstMap) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }
}