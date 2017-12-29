package com.yy.study.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day20" + "?user=root&password=root");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return null;
    }
}
