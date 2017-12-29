package com.yy.study.dao;

import com.yy.study.util.jdbc;
import com.yy.study.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    //查询表中所有信息
    public static List<User> searchAll() throws SQLException {
        Connection conn=null;
        try {
            conn= jdbc.getConnection();
            List<User> users = new QueryRunner().query(conn,
                    "select * from hw_user",
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

    public static void insertUser(User user) throws SQLException {
        String sql="insert into hw_user values(null,?,?,?)";
        Connection conn=null;
        try {
            conn = jdbc.getConnection();
            new QueryRunner().update(
                    conn,
                    sql,
                    user.getUname(),
                    user.getAge(),
                    user.getLoc());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }
}
