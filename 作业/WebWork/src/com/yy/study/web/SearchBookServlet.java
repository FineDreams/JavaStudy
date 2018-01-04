package com.yy.study.web;

import com.yy.study.dao.BookDao;
import com.yy.study.domain.Book;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchBookServlet",urlPatterns = "/search")
public class SearchBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BookDao bookDao=new BookDao();
        String bkname = request.getParameter("bkname");
//        List<Book> bookList = bookDao.searchByName(bkname);
        response.sendRedirect("http://localhost:8080/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
