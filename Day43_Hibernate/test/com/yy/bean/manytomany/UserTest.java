package com.yy.bean.manytomany;

import com.yy.util.HibernateUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void save(){
        HibernateUtil.handle(session -> {
           User user=new User();
           user.setUname("张三");
           Role role=new Role();
           role.setRname("管理员");

           role.getUsers().add(user);
           user.getRoles().add(role);

           session.save(user);
            return null;
        });
    }

    @Test
    public void get(){
        HibernateUtil.handle(session -> {
            User user = session.get(User.class, "40288b52610d827901610d827c8f0000");
            System.out.println(user.getRoles());
            System.out.println(user);
            return null;
        });
    }

}