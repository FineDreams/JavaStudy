package com.yy.jar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
   public interface ResultHandle<T> {
        T resultHandle(Session session);
    }
   private static SessionFactory SF;

    static {
       SF=new Configuration().configure().buildSessionFactory();
    }


    public static  <T> T handle(ResultHandle<T> rH){

        Session session = SF.openSession();
//        Transaction transaction1 = session.beginTransaction();
        session.beginTransaction();

        T t=rH.resultHandle(session);

//        Transaction transaction = session.getTransaction();
        //将Transaction提交事务
        session.getTransaction().commit();
//        transaction.commit();
//        transaction1.commit();

        session.close();

        return t;

    }

}
