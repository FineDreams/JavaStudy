package com.yy.study.web;

import com.yy.study.dao.BookDao;
import com.yy.study.dao.UserDao;
import com.yy.study.domain.Book;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookServlet",urlPatterns = "/bookInfo")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        BookDao bookDao=new BookDao();
        Book book=new Book();
        try {
            BeanUtils.populate(book,parameterMap);
            bookDao.insertBook(book);
            response.sendRedirect("http://localhost:8080/index.jsp");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        BookDao bookDao=new BookDao();
        List<Book> books= bookDao.searchAllBook();
        JSONArray jsonArray=JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());

    }
}
