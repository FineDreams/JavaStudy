package com.yy.dao.impl;

import com.yy.dao.UserDao;
import com.yy.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    public void addUser(User user) {
        this.getHibernateTemplate().save(user);
    }

    public List<User> login(String username) {
        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=?", username);
        return list;
    }
}
