package com.yy.work;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {
    static {
        Properties prop=new Properties();
        try {
            prop.load(new FileReader("src/jdbc.properties"));
            String driverName = prop.getProperty("driverName");
            url = prop.getProperty("url");
            database = prop.getProperty("database");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private static String url;
    private static String database;
    private static String user;
    private static String password;

    public static void execute(ExecuteInter exe){
        try {
            Connection conn= DriverManager.getConnection(url+database,user,password);
            exe.execute(conn).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
