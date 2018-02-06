package com.yy.netctoss.admin.dao;

import com.yy.netctoss.admin.domain.Admin_info;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Admin_infoMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

    }
    @Test
    public void testFind(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Admin_infoMapper adminInfoMapper = sqlSession.getMapper(Admin_infoMapper.class);
        Admin_info admin_info = adminInfoMapper.selectByPrimaryKey(2000);
        System.out.println(admin_info);
        sqlSession.close();
    }



}