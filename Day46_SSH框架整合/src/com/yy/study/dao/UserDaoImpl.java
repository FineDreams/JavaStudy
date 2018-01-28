package com.yy.study.dao;

import com.yy.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Autowired
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void add() {
        this.getHibernateTemplate().save(user);
        System.out.println("增加");
    }
}
