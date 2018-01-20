package com.yy.bean;

import com.yy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class StudentTest {
    //快速删除类中无用的import语句
    //alt+ctrl+o
    @Test
    public void hello(){
        //获得配置信息对象
        new Configuration().configure().buildSessionFactory();
    }
    @Test
    public void save(){
        //往数据库插入信息
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//
//        session.beginTransaction();
//
//        Student student=new Student();
//
//        student.setSid(1);
//        student.setName("猴子");
//        student.setAge(200);
//        student.setGender("男");
//
//        session.save(student);
//        session.getTransaction().commit();
//        session.close();

//        Student student = HibernateUtil.handle(new HibernateUtil.ResultHandle<Student>() {
//            @Override
//            public Student resultHandle(Session session) {
//                return session.get(Student.class, 1l);
//            }
//        });
        Student student = HibernateUtil.handle(session -> session.get(Student.class, 1l));

        System.out.println(student);


    }
    @Test
    public void get(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();

        //通过id找到对应数据
        Student student=session.get(Student.class,1L);
        Student s=session.get(Student.class,1L);

        //托管
        //将s指向的对象，从持久化状态转为游离状态
        //此时hibernate也就不再维护该对象的状态
        //什么叫维护
        //只要一个对象处于持久化状态
        //hibernate就会保证他的属性值与数据库中的一致
        session.evict(s);
        s.setName("赵六");
        System.out.println(student);

        session.getTransaction().commit();
        session.close();

    }
    @Test
    public void update(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();

        session.beginTransaction();

        Student student=session.get(Student.class,1L);

        //三种状态
//            临时状态
//                持久化状态
//                  游离状态
//      将一个对象变成游离状态，表示hibernate不再对这个对象进行维护，后续操作只会改变缓存中的内容但是不会将其更新到数据库中
//        session.evict(student);
        student.setName("紫霞");
        //是不需要再执行session.update()方法的

        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void delete(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, 1l);

        session.delete(student);

        session.getTransaction().commit();
        session.close();


    }
    @Test
    public void flush(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, 1l);
        Student student1 = session.get(Student.class, 2l);
        student1.setName("齐天大圣");
        Student student2=new Student();
        student2.setName("天蓬元帅");
        student2.setGender("男");
        student2.setAge(100);

        session.save(student2);

        session.flush();

        session.getTransaction().commit();
        session.close();
    }

}