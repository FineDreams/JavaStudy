package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3POUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

    public void insertUser(User fromTable){
        Connection conn = C3POUtil.getConnection();
        String sql="insert into user values(?,?,?,?)";
        try {
             new QueryRunner().update(conn, sql, fromTable.getUsername(), fromTable.getPassword(),fromTable.getPhone(),fromTable.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
    }

    public User searchUser(String username){
        Connection connection = C3POUtil.getConnection();
        String sql="select * from user where username=?";
        User user=new User();
        try {
             user = new QueryRunner().query(connection, sql, new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(connection);
        }
        return user;
    }

}
