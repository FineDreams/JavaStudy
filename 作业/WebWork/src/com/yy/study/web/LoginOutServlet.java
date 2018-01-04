package com.yy.study.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginOutServlet",urlPatterns = "/loginOut")
public class LoginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null){
            response.sendRedirect("http://localhost:8080/login.jsp");
            return;
        }

        String uname =(String ) session.getAttribute("uname");
        Cookie cookie=new Cookie("username",uname);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        session.removeAttribute("uname");
//        getServletContext().setAttribute("uname",uname);

        response.sendRedirect("http://localhost:8080/login.jsp");
    }
}
