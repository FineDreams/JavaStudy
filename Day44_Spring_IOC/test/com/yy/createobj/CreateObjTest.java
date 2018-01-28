package com.yy.createobj;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CreateObjTest {

    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        //@Before注解标注的方法
        //会在每个@Test方法前执行

        //下面语句是在获得ApplicationContext
        //几乎Spring所有的操作，都要先获得这个对象
        //这个对象会加载配置文件中的信息
        //通过这个对象，我们可以让spring帮助我们创建对象
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }
    @Test
    //无参构造方法
    public void helloSpring(){
        context.getBean("user");

    }
    @Test
    //带参数的构造方法
    public void constructor(){

    }

    @Test
    public void property() throws Exception{
        //去Spring框架中的map中取出创建好的对象
        User user = (User) context.getBean("user");

        User user2 = (User) context.getBean("user2");
        User user3 = (User) context.getBean("user2");
        System.out.println(user2 == user3);
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user3);

    }
}