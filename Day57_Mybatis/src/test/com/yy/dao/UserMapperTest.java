package com.yy.dao;

import com.yy.domain.Orders;
import com.yy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void findUserTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findUser();
        System.out.println(userList.toString());
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        User user=new User();
//        user.setId(34);
        user.setUsername("再次测试");
        mapper.insertUser(user);
        sqlSession.commit();

        System.out.println(user.getId());
        Orders orders1=new Orders();
        orders1.setNumber(1101);
        orders1.setUser_id(user.getId());
        ordersMapper.insertOrders(orders1);

        Orders orders2=new Orders();
        orders2.setNumber(1102);
        orders2.setUser_id(user.getId());
        ordersMapper.insertOrders(orders2);

        Orders orders3=new Orders();
        orders3.setNumber(1103);
        orders3.setUser_id(user.getId());
        ordersMapper.insertOrders(orders3);

        Orders orders4=new Orders();
        orders4.setNumber(1104);
        orders4.setUser_id(user.getId());
        ordersMapper.insertOrders(orders4);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper1);
        System.out.println(userMapper2);
        System.out.println(userMapper3);
    }
}