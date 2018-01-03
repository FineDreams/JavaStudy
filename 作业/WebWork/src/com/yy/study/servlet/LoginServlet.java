package com.yy.study.servlet;

import com.yy.study.dao.UserDao;
import com.yy.study.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = UserDao.searchUsername(uname);
//            System.out.println(user.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user!=null){
            if (user.getPassword().equals(password)){
                getServletContext().setAttribute("nickname",user.getNickname());
                response.sendRedirect("http://localhost:8080/index.jsp");
            }else {
                response.getWriter().write("密码错误，请重新输入!");
                response.sendRedirect("http://localhost:8080/Login.html");
            }
        }else {
            response.getWriter().write("用户名不存在!");
            response.sendRedirect("http://localhost:8080/Login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname =(String) getServletContext().getAttribute("nickname");
        response.getWriter().write(nickname);

    }
}
