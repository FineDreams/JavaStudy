package com.yy.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Regist {
    public static void userRegist(String nickName,String userName,String passWord){
        jdbcUtil.execute(new ExecuteInter() {
            @Override
            public Statement execute(Connection conn) throws SQLException {
                PreparedStatement pstate=conn.prepareCall("INSERT INTO person VALUES (NULL ,?,?,?)");
                pstate.setString(1,nickName);
                pstate.setString(2,userName);
                pstate.setString(3,passWord);
                return pstate;
            }
        });
    }
}
