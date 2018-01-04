package com.yy.study.web;

import com.yy.study.dao.BookDao;
import com.yy.study.dao.UserDao;
import com.yy.study.domain.Book;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowBookInfoServlet",urlPatterns = "/showBook")
public class ShowBookInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        BookDao bookDao=new BookDao();
        String bid =(String) request.getParameter("bid");
        Book book = bookDao.searchBook(bid);
        JSONObject jsonObject = JSONObject.fromObject(book);
        response.getWriter().write(jsonObject.toString());

    }
}
