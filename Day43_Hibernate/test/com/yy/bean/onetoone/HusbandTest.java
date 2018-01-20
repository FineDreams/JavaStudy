package com.yy.bean.onetoone;

import com.yy.util.HibernateUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class HusbandTest {

    @Test
    public void save(){
        HibernateUtil.handle(session -> {
            Husband husband=new Husband();
            husband.setHname("赵明诚");

            Wife wife=new Wife();
            wife.setWname("李清照");

            husband.setWife(wife);
            wife.setHusband(husband);
            session.save(husband);
            return null;
        });
    }

    @Test
    public void get(){
        HibernateUtil.handle(session -> {
           Husband husband=session.get(Husband.class,1);

            return husband;
        });
    }

}