package com.yy.study.dao;

import com.yy.study.domain.User;
import com.yy.study.util.jdbc;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    public static List<User> searchAll() throws SQLException {
        Connection conn=null;
        try {
            conn= jdbc.getConnection();
            List<User> users = new QueryRunner().query(conn,
                    "select * from users",
                    new BeanListHandler<User>(User.class));
            return users;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }
}