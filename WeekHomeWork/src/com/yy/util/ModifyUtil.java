package com.yy.util;

import com.yy.entity.Person;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyUtil {
    //删
    public static void delete(String column,String col) throws SQLException {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement psate = connection.prepareStatement("DELETE FROM users WHERE "+column+"=?");
        psate.setString(1,col);
        psate.execute();

        connection.close();
        psate.close();
    }

    //改
    public static void update(String column,String col,String col2) throws SQLException {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement psate = connection.prepareStatement("UPDATE users SET "+column+"=? WHERE "+column+"=?");
        psate.setString(1,col2);
        psate.setString(2,col);
        psate.execute();

        connection.close();
        psate.close();
    }

    //查看账户
    public static void query(String...usernames) throws SQLException {
        for (String username:usernames) {
            Person person = new QueryRunner().query(jdbcUtil.getConnection(),
                    "select * from users where uname=?",
                    new BeanHandler<Person>(Person.class),
                    username
            );
            System.out.println(person.toString());
        }
    }


}
