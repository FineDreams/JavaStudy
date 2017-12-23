package com.yy.study.utils;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MySQLUtilTest {
    @Test
    public void m() throws SQLException {
//        MySQLUtil.insert("李四","23","北京");
//        MySQLUtil.delete("uname","李四");
//        MySQLUtil.update("uname","李四","张一山");
//        MySQLUtil.query("李小龙","崔浩月");
        System.out.println(MySQLUtil.query("李小龙", "崔浩月", "李四").toString());
    }

}