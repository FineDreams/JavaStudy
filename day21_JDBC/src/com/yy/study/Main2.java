package com.yy.study;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //将Driver类加载进内存
        //也就会执行该类的静态代码块
        //也就实现了注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn=DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/day20"+"?user=root&password=root"
        );


        Statement statement=conn.createStatement();
//        int i=statement.executeUpdate("INSERT INTO hw_user VALUES (NULL ,'张一山',40,'北京')");
        int i=statement.executeUpdate("DELETE FROM hw_user WHERE uid BETWEEN 34 AND 38");
        String sql="select * from hw_user";

        //i受影响的行数
        System.out.println(i);

        ResultSet resultSet = statement.executeQuery(sql);
       jdbcUtil.shouRs(resultSet);
        System.out.println();


        conn.close();
        statement.close();
        resultSet.close();
    }
}
