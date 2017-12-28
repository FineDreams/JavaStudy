package com.yy.study.utils;
import com.yy.study.User;
import com.yy.study.WhQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MySQLUtil {

    //数据库中增、删、改、查

    //增
    public static void insert(String uname,String age,String loc) throws SQLException {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement psate = connection.prepareStatement("INSERT INTO hw_user VALUES (NULL ,?,?,?)");
        psate.setString(1,uname);
        psate.setString(2,age);
        psate.setString(3,loc);

        psate.addBatch();
        psate.executeBatch();

        connection.close();
        psate.close();
    }

    //删
    public static void delete(String column,String col) throws SQLException {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement psate = connection.prepareStatement("DELETE FROM hw_user WHERE "+column+"=?");
        psate.setString(1,col);
        psate.execute();

        connection.close();
        psate.close();
    }

    //改
    public static void update(String column,String col,String col2) throws SQLException {
        Connection connection = jdbcUtil.getConnection();


        PreparedStatement psate = connection.prepareStatement("UPDATE hw_user SET "+column+"=? WHERE "+column+"=?");
        psate.setString(1,col2);
        psate.setString(2,col);
        psate.execute();

        connection.close();
        psate.close();
    }

    //查
    //如果想要一个对象：BeanHandler<>
    public static List<User> query(String...usernames) throws SQLException {
        List<User> list=new ArrayList<>();
        for (String username:usernames) {
            User user = new WhQueryRunner().query(jdbcUtil.getConnection(),
                    "select * from hw_user where uname=?",
                    new BeanHandler<User>(User.class),
            username
            );
            list.add(user);
        }
        return list;
    }
    //如果想要一个Map：MapHandler
    public static Map<String,Object> queryMap(String...ID) throws SQLException {
        for (String id:ID) {
            Map<String, Object> objectMap = new WhQueryRunner().query(jdbcUtil.getConnection(),
                    "select * from hw_user where uid=?",
                    new MapHandler(),
                    id
            );
            return objectMap;
        }
        return null;
    }
}
