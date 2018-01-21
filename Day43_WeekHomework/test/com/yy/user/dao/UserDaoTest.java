package com.yy.user.dao;

import com.yy.user.domain.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.beans.Transient;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void search(){

        List<User> users = new UserDao().queryByUsername("root");
        System.out.println(users.size());
    }

    public void a(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.getTransaction();

    }


}