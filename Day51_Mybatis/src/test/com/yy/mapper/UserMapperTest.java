package com.yy.mapper;

import com.yy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }


    @Test
    public void testSearchUserById(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.searchUserById(1);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void testSearchUsersByName(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.searchUsersByName("王");
        for (User user : userList) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User(0,"智障","女",new Date(),"上海");

        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
}