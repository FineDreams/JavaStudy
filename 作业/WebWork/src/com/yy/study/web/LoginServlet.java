package com.yy.study.web;

import com.yy.study.dao.BookDao;
import com.yy.study.dao.UserDao;
import com.yy.study.domain.Book;
import com.yy.study.domain.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
//                getServletContext().setAttribute("uname",user.getNickname());
                HttpSession session = request.getSession();
                session.setAttribute("uname",user.getUname());
                request.setAttribute("uname",user.getUname());
                response.sendRedirect("http://localhost:8080/index.jsp");
            }else {
                response.getWriter().write("密码错误，请重新输入!");
                response.sendRedirect("http://localhost:8080/login.jsp");
            }
        }else {
            response.getWriter().write("用户名不存在!");
            response.sendRedirect("http://localhost:8080/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        String uname =(String) getServletContext().getAttribute("uname");
        HttpSession session = request.getSession();
        String uname =(String) session.getAttribute("uname");
        response.getWriter().write(uname);


    }
}
