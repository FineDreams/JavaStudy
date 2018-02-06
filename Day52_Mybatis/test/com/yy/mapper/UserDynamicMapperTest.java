package com.yy.mapper;

import com.yy.domain.User;
import com.yy.domain.UserExt;
import com.yy.domain.UserQueryV0;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDynamicMapperTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void findUsersByQueryV0(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDynamicMapper dynamicMapper = sqlSession.getMapper(UserDynamicMapper.class);
        UserQueryV0 userQueryV0=new UserQueryV0();
        UserExt userExt=new UserExt();
        userExt.setSex("男");
        userExt.setUsername("王五");
        userQueryV0.setUserExt(userExt);
        List<UserExt> usersByQueryV0 = dynamicMapper.findUsersByQueryV0(userQueryV0);
        for (UserExt userExt1 : usersByQueryV0) {
            System.out.println(userExt1.toString());
        }
        sqlSession.close();
    }

    @Test
    public void findUsersCount(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDynamicMapper dynamicMapper = sqlSession.getMapper(UserDynamicMapper.class);
        UserQueryV0 userQueryV0=new UserQueryV0();
        UserExt userExt=new UserExt();
        userExt.setSex("男");
        userQueryV0.setUserExt(userExt);
        int usersCount = dynamicMapper.findUsersCount(userQueryV0);
        System.out.println(usersCount);
        sqlSession.close();
    }

    @Test
    public void findUsersByQueryV02(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDynamicMapper mapper = sqlSession.getMapper(UserDynamicMapper.class);
        UserQueryV0 userQueryV0=new UserQueryV0();
        List<Integer> idList=new ArrayList<Integer>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(6);
        userQueryV0.setIdList(idList);
        List<UserExt> userList = mapper.findUserList(userQueryV0);
        for (UserExt userExt : userList) {
            System.out.println(userExt.toString());
        }
        sqlSession.close();
    }
    @Test
    public void findUsersByIdListTest(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDynamicMapper mapper = sqlSession.getMapper(UserDynamicMapper.class);
        List<Integer> idList=new ArrayList<Integer>();
        idList.add(1);
        idList.add(5);
        idList.add(9);
        List<UserExt> usersByIdList = mapper.findUsersByIdList(idList);
        for (UserExt userExt : usersByIdList) {
            System.out.println(userExt.toString());
        }
        sqlSession.close();
    }

}