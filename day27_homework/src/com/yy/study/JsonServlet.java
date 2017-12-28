package com.yy.study;

import net.sf.json.JSONArray;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JsonServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        List<User> users=null;
        try {
            users = new QueryRunner().query(jdbc.getConnection(),
                    "select * from hw_user",
                    new BeanListHandler<User>(User.class));
//            System.out.println(users.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray=JSONArray.fromObject(users);
        resp.getWriter().write(jsonArray.toString());
    }
}
