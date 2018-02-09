package com.yy.domain;

import com.yy.mapper.UserDynamicMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserQueryV0Test {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void findUsersByQueryV0Test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDynamicMapper mapper = sqlSession.getMapper(UserDynamicMapper.class);
        UserQueryV0 userQueryV0=new UserQueryV0();
        UserExt userExt=new UserExt();
        userExt.setSex("女");
        userExt.setUsername("王");
        userQueryV0.setUserExt(userExt);
        List<UserExt> userList = mapper.findUserList(userQueryV0);
        for (UserExt ext : userList) {
            System.out.println(ext);
        }
    }

    @Test
    public void findUsersByIdListTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDynamicMapper mapper = sqlSession.getMapper(UserDynamicMapper.class);
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(15);
        UserQueryV0 userQueryV0=new UserQueryV0();
        userQueryV0.setIdList(list);
        List<UserExt> usersByIdList = mapper.findUserList(userQueryV0);
        for (UserExt userExt : usersByIdList) {
            System.out.println(userExt);
        }

    }

}