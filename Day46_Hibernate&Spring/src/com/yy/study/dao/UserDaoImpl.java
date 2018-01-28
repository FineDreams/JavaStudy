package com.yy.study.dao;

import com.yy.study.dao.UserDao;
import com.yy.study.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void add() {
        this.getHibernateTemplate().save(user);
        System.out.println("添加好了!!!!");
    }
}
