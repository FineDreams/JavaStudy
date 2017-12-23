package com.yy.study;

import com.yy.study.utils.jdbcUtil;

import java.sql.*;

public class Main5 {

    /*
    1、PrepareStatement 可以使用动态参数
        Statement只能执行静态的sql语句

    2、防止sql注入
        什么是sql注入？
        select * from user where username=? and
     */

    String user="zhangSan";
    String password="123";
    String sql="select * from user where username="+user+"and password="+password;




    public static void main(String[] args) {
        jdbcUtil.execute(conn -> {
            try {
                PreparedStatement pstate = conn.prepareStatement("SELECT * FROM hw_user" +
                        " WHERE loc=? " +
                        "AND age>?");

                //1 表示第几个问号
                pstate.setString(1,"北京");
                pstate.setInt(2,20);
                ResultSet resultSet = pstate.executeQuery();
                jdbcUtil.shouRs(resultSet);
                return pstate;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
