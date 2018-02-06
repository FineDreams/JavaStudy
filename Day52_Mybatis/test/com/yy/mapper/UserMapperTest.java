package com.yy.mapper;

import com.yy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }


    @Test
    public void findUserByIdResultMapTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User idResultMap = userMapper.findUserByIdResultMap(1);
        System.out.println(idResultMap.toString());
        sqlSession.close();
    }

    @Test
    public void findUserByNameResultMapTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByNameResultMap("王");
        for (User user : users) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

}