package com.yy.bookstore.user.dao;

import com.yy.bookstore.user.domain.User;
import com.yy.bookstore.utils.MyQueryRunner;
import com.yy.bookstore.utils.jdbc.C3POUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public int insertUser(User user){
        String sql="insert into tb_user values(?,?,?,?,?,?)";
        Connection conn = C3POUtil.getConnection();
        int update=0;
        try {
            update = new MyQueryRunner().update(conn, sql,
                    user.getUid(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getCode(),
                    user.getState());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                C3POUtil.release(conn);
        }
        return update;
    }

    public User queryByUserName(String username){
        String sql="select * from tb_user where username=?";
        Connection conn = C3POUtil.getConnection();
        try {
            User user = new MyQueryRunner().query(conn, sql, new BeanHandler<User>(User.class),username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }
    public User queryByEmail(String email){
        String sql="select * from tb_user where email=?";
        Connection conn = C3POUtil.getConnection();
        try {
            User user = new MyQueryRunner().query(conn, sql, new BeanHandler<User>(User.class),email);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }
    public User queryByCode(String code){
        String sql="select * from tb_user where code=?";
        Connection conn = C3POUtil.getConnection();
        try {
            User user = new MyQueryRunner().query(conn, sql, new BeanHandler<User>(User.class),code);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }
    public void updateState(String fromUid,int st) throws SQLException {
        Connection conn = C3POUtil.getConnection();
        String sql="update tb_user set state=? where uid=?";
         new MyQueryRunner().update(conn, sql, st, fromUid);

        C3POUtil.release(conn);
    }
}
