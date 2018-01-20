package com.yy.bean;

import com.yy.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ClazzTest {
    /**
     *
     * 通过debug
     * 我们发现，在执行save方法后
     * 缓存map中，也出现了两条数据
     *
     * 所以我们可以知道
     * save方法可以将数据保存到缓存中
     *
     *
     */


    @Test
    public void save(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();


        Clazz clazz=new Clazz();

//        clazz.setCid(2);
        clazz.setCname("一年二班");


        Clazz clazz1=new Clazz();
//        clazz1.setCid(3);
        clazz1.setCname("一年三班");
        session.beginTransaction();
        session.save(clazz);
        session.getTransaction().commit();

        session.beginTransaction();
        Clazz clazz2 = session.get(Clazz.class, 1);
        System.out.println(clazz1);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void get(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();

        Clazz clazz = session.get(Clazz.class, 2);
        System.out.println(clazz);
        session.getTransaction().commit();
        session.close();

        Clazz clazz1 = session.get(Clazz.class, 2);
        System.out.println(clazz1);
        session.beginTransaction();

        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void evict(){
        HibernateUtil.handle(new HibernateUtil.ResultHandle<Clazz>() {
            @Override
            public Clazz resultHandle(Session session) {
                //这里这个get会将找到的班级对象，存入缓存中
                Clazz clazz = session.get(Clazz.class, 3);
                //evict方法，会将这个班级对象从缓存中移出
                session.evict(clazz);

                //缓存中没有这个对象了
                //再次get，会去数据库中再查一遍
                Clazz clazz1 = session.get(Clazz.class, 3);
                return null;
            }
        });

    }

    @Test
    public void oneToMany1(){

        HibernateUtil.handle(session -> {
            Student zhangSan=new Student();
            Student liSi=new Student();
            zhangSan.setName("张三");
            liSi.setName("李四");

            session.save(zhangSan);
            session.save(liSi);

            Clazz clazz=new Clazz();
            clazz.getStudents().add(zhangSan);
            clazz.getStudents().add(liSi);
            clazz.setCname("四年四班");

            session.save(clazz);
            return null;
        });
    }

    @Test
    public void oneToMany2(){

        HibernateUtil.handle(session -> {
            Student wangWu=new Student();
            wangWu.setName("王五");
            Student zhaoLiu=new Student();
            zhaoLiu.setName("赵六");

            Clazz clazz=new Clazz();
            clazz.setCname("java班级");
            clazz.getStudents().add(wangWu);
            clazz.getStudents().add(zhaoLiu);

            //因为设置了级联属性为save-update
            //所以保存班级时，也会级联保存学生
            session.save(clazz);
            return null;
        });

    }

    @Test
    public void oneToMany3(){
        HibernateUtil.handle(session -> {
            Clazz clazz = session.get(Clazz.class, 1);
            clazz.getStudents().add(new Student("小红"));
            clazz.getStudents().add(new Student("小明"));
            return null;
        });
    }

    @Test
    public void oneToMany4(){
        HibernateUtil.handle(session -> {
            Clazz clazz=session.get(Clazz.class,2);

            //给两个学生一个班级对象
            Student student=new Student("张三疯");
            student.setClazz(clazz);
            Student student1=new Student("李隆基");
            student1.setClazz(clazz);

            session.save(student);
            session.save(student1);
            return null;
        });

    }

    @Test
    public void validateSecond(){
        HibernateUtil.handle(session -> {
            //查找数据，得到数据
            //然后将数据存到一级缓存中，存到二级缓存中
            Clazz clazz=session.get(Clazz.class,1);

            //这里，发现一级缓存中有该数据
            //则直接从一级缓存中存取，不再查找数据库
            clazz=session.get(Clazz.class,1);
            return null;
        });
        HibernateUtil.handle(session -> {
            //这里，已经不再是上一个session了
            //是一个新的session了
            //所以一级缓存中，肯定没数据
            //那么去二级缓存中找，也找到了
            //所以也不会去查找数据库
          Clazz clazz=session.get(Clazz.class,1);
          return null;
        });
    }
    @Test
    public void query(){
        HibernateUtil.handle(session -> {
            //from后面跟着的是类的全名
            Query query = session.createQuery("from " + Clazz.class.getName());

            List<Clazz> list = query.list();
            for (Clazz clazz : list) {
                System.out.println(clazz);
            }
            //输出，二级缓存中数据总数
            //这个得在配置文件中，配置开启二级缓存统计
            System.out.println(
                    session.getSessionFactory()
                            .getStatistics()
                            .getEntityLoadCount());
            return null;
        });
    }
    @Test
    public void queryCache(){
        HibernateUtil.handle(session -> {
            Query query = session.createQuery("from " + Clazz.class.getName());
            //手动开启查询缓存
            query.setCacheable(true);
            List list = query.list();

            System.out.println(Arrays.toString(list.toArray()));

            return null;
        });
    }

}