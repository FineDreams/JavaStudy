package com.yy.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main6 {
    public static void main(String[] args) {
        // {}就是匿名内部类实现ExecuteInter接口时
        //复写的那个方法execute的方法体
        //conn就是execute方法的参数
        jdbcUtil.execute(conn -> {
            try {
                PreparedStatement pstate= conn.prepareStatement("INSERT  INTO hw_user VALUES (null,'张三',30,'上海')");

                //将30岁的张三插入到批处理中
                pstate.addBatch();
                //添加批处理任务
                pstate.addBatch("INSERT  INTO  hw_user VALUES (null,'张三',10,'武汉')");
                pstate.addBatch("INSERT  INTO  hw_user VALUES (null,'李四',10,'武汉')");
                //开始执行
                pstate.executeBatch();
                return pstate;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
