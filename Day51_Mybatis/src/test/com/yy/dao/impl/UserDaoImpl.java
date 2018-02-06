package com.yy.dao.impl;

import com.yy.dao.UserDao;
import com.yy.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }


    public User findUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("user.findUserById",id);
    }

    public List<User> findUsersByName(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("user.findUsersByName",username);
    }

    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("user.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
