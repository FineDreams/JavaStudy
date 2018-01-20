package com.yy.bean;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void save(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Student student=new Student();
//        student.setSid(1);
        student.setName("小七");
        student.setGender("男");
        student.setAge(10);

        session.save(student);
        session.getTransaction().commit();
        session.close();

    }

}