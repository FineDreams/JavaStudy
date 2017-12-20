package com.yy.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcUtil {
    static {
        try {
            Properties prop=new Properties();
            prop.load(new FileReader("src/jdbc.properties"));
            String driverName=prop.getProperty("driverName");
            url = prop.getProperty("url");
            database = prop.getProperty("database");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+
                    "\n\t\t"+
                    "请将配置文件jdbc.properties放置到src目录下");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String url;
    private static String database;
    private static String user;
    private static String password;

    public static Connection getConnection() {
        try {

            Connection conn= DriverManager.getConnection(url+database,user,password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void execute(ExecuteInter e)  {
        try {
            Connection conn= DriverManager.getConnection(url+database,user,password);
            e.execute(conn).close();
           conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
    public static void shouRs(ResultSet resultSet){
        try {
            while (resultSet.next()){
                System.out.print(resultSet.getString(1) + "\t");
                System.out.print(resultSet.getString(2) + "\t");
                System.out.print(resultSet.getString(3) + "\t");
                System.out.print(resultSet.getString(4) + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
