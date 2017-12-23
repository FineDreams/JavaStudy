package com.yy.study;

import com.yy.study.utils.jdbcUtil;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class WhQueryRunnerTest {
    /*
    根据需求结果的类型，选择ResultSetHandler的实现类
    如果结果集为单行单列：ScalarHandler<>
    如果想要一个对象的集合：BeanListHandler<>
    如果想要一个对象：BeanHandler<>
    如果想要一个Map：MapHandler
    如果想要一个Map集合：MapHandler
    如果想要一个数组：ArrayHandler
    如果想要一个数组的集合：ArrayListHandler

     */


    @Test
    public void queryByParams() throws SQLException {
//        Object[] query = new WhQueryRunner().query(jdbcUtil.getConnection(),
//                "select * from hw_user where loc=?", new ArrayHandler(),
//                "北京");
//        List<Object[]> query1 = new WhQueryRunner().query(jdbcUtil.getConnection(),
//                "select * from hw_user",
//                new ArrayListHandler()
//        );

        Long query2 = new WhQueryRunner().query(jdbcUtil.getConnection(),
                "select count(*) from hw_user",
                new ScalarHandler<Long>()
        );
        //Number类
        //可以接收任何数值类型的值
        //Number类中有获取各种整型值的方法
        Number number=query2;
        //获得int值
        int i=number.intValue();
        System.out.println(i);


//        for (Object[] o:query1) {
//            System.out.println(Arrays.toString(o));
//        }


    }
    @Test
    public void queryBean() throws SQLException {
        User user = new WhQueryRunner().query(
                jdbcUtil.getConnection(),
                "select * from hw_user",
                new BeanHandler<User>(User.class));
        System.out.println(user);

        List<User> users = new WhQueryRunner().query(
                jdbcUtil.getConnection(),
                "select * from hw_user",
                new BeanListHandler<User>(User.class));
        System.out.println(users);

    }

    @Test
    public void queryMap() throws SQLException {
        Map<String, Object> objectMap = new WhQueryRunner().query(
                jdbcUtil.getConnection(),
                "select * from hw_user",
                new MapHandler());

        System.out.println(objectMap.toString());


//        List<Map<String, Object>> mapList = new WhQueryRunner().query(
//                jdbcUtil.getConnection(),
//                "select * from hw_user",
//                new MapListHandler());
//
//        for (Map<String,Object> map:mapList) {
//            System.out.println(map.toString());
//        }
    }
}
