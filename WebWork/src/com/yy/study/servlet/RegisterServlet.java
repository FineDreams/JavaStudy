package com.yy.study.servlet;

import com.yy.study.dao.UserDao;
import com.yy.study.domain.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        List<User> users= null;
        try {
            users = UserDao.searchAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray=JSONArray.fromObject(users);
        resp.getWriter().write(jsonArray.toString());
    }
}
