package com.yy.study.dao;

import com.yy.study.domain.Book;
import com.yy.study.domain.User;
import com.yy.study.util.jdbc;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
    public static User searchUsername(String username) throws SQLException {
        String sql="select * from users where uname=?";
        Connection conn=null;
        try {
            conn=jdbc.getConnection();
            User user = new QueryRunner().query(conn,
                    sql,
                    new BeanHandler<User>(User.class),
                username
            );
            return user;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }

    public static int insertUser(User user) throws SQLException {
        String sql="insert into users values(?,?,?)";
        Connection conn=null;
        int update=0;
        try {
            conn= jdbc.getConnection();
            update = new QueryRunner().update(
                    conn,
                    sql,
                    user.getNickname(),
                    user.getUname(),
                    user.getPassword()

            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return update;
    }

}
