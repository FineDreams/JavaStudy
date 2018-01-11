package com.yy.bookstore.admin.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.admin.service.exception.AdminPasswordErrorException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet",urlPatterns = "/adminUser")
public class AdminServlet extends BaseServlet {
    public String login(HttpServletRequest request,HttpServletResponse response){
        String adminname = request.getParameter("adminname");
        String password = request.getParameter("password");
        if ("root".equals(adminname)&&"123456".equals(password)){
            request.getSession().setAttribute("adminname",adminname);
            return "f:/adminjsps/admin/body.jsp";
        }else {
            try {
                throw new AdminPasswordErrorException();
            } catch (AdminPasswordErrorException e) {
                request.setAttribute("errorMsg",e.getMessage());
                return "f:/adminjsps/login.jsp";
            }

        }


    }
}
