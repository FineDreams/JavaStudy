package com.yy.order.mapper;

import com.yy.domain.User;
import com.yy.order.domain.OrderDetail;
import com.yy.order.domain.Orders;
import com.yy.order.domain.OrdersExt;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrdersMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void findOrdersUserTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersExt> ordersUser = mapper.findOrdersUser();
        for (OrdersExt ordersExt : ordersUser) {
            System.out.println(ordersExt);
        }
    }

    @Test
    public void testFindOrdersUserRstMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersUserRstMap = mapper.findOrdersUserRstMap();
        for (Orders orders : ordersUserRstMap) {
            System.out.println(orders);
        }
    }
    @Test
    public void testFindOrdersAndOrderdetailRstMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersAndOrderdetailRstMap = mapper.findOrdersAndOrderdetailRstMap();
        for (Orders orders : ordersAndOrderdetailRstMap) {
            List<OrderDetail> detailList = orders.getDetailList();
            for (OrderDetail orderDetail : detailList) {
                for (OrderDetail detail : detailList) {
                    System.out.println(detail);
                }
            }
        }
        System.out.println(ordersAndOrderdetailRstMap.toString());
        sqlSession.close();
    }

    @Test
    public void testFindUserAndItemsRstMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> userAndItemsRstMap = mapper.findUserAndItemsRstMap();
        for (User user : userAndItemsRstMap) {
            System.out.println(user.toString());
        }
    }

}