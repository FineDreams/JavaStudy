package com.yy.user.dao;

import com.yy.jar.HibernateUtil;
import com.yy.user.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserDao {

    public List<User> queryByUsername(String username){
        
        List<User> users = HibernateUtil.handle(session -> {
            Query query = session.createQuery("SELECT u from User u where u.username=?");
            query.setParameter(0, username);
            return query.list();
        });
        return users;
    }

}
