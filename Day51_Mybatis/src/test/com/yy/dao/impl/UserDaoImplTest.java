package com.yy.dao.impl;

import com.yy.dao.UserDao;
import com.yy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test

    public void testFindUserById() {
        UserDao userDao=new UserDaoImpl(sessionFactory);
        User userById = userDao.findUserById(9);
        System.out.println(userById.toString());
    }

    @Test
    public void testFindUsersByName() {
        UserDao userDao=new UserDaoImpl(sessionFactory);
        List<User> userList = userDao.findUsersByName("王");
        for (User user : userList) {
            System.out.println(user.toString());
        }

    }

    @Test
    public void TestInsertUser() {
        UserDao userDao=new UserDaoImpl(sessionFactory);
        User user=new User(0,"大圣","男",new Date(),"花果山");
        userDao.insertUser(user);
    }
}