package com.yy.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void insertUser() throws Exception {
        User user=new User(0,"李国易","阳",new Date(),"中南海");

        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //把配置文件中的信息封装成一个对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();

        sqlSession.insert("user.insertUser",user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void selectUser() throws Exception {
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        List<Object> selectList = sqlSession.selectList("user.selectByName","王");
//        System.out.println(selectList.toString());
        for (Object o : selectList) {
            System.out.println(o.toString());
        }

    }

    @Test
    public void updateUser() throws Exception {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        User user=new User();
        user.setId(13);
        user.setSex("未知");
        user.setUsername("无敌");
        sqlSession.update("user.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws Exception {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        sqlSession.delete("user.deleteUser",5);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test

    public void deleteByName() throws Exception {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        sqlSession.delete("user.deleteByName","无敌");
        sqlSession.commit();
        sqlSession.close();


    }
}