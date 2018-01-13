package com.yy.bookstore.book.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.book.dao.BookDao;
import com.yy.bookstore.book.domain.Book;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet{

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao=new BookDao();
        List<Book> books = bookDao.queryAll();
        request.setAttribute("books",books);
        return "f:/jsps/book/list.jsp";
    }
    public String findByCategory(HttpServletRequest request, HttpServletResponse response){
        BookDao bookDao=new BookDao();
        String category = request.getParameter("category");
        List<Book> books = bookDao.queryByCategory(category);
        request.setAttribute("books",books);
        return "f:/jsps/book/list.jsp";

    }
    public String load(HttpServletRequest request, HttpServletResponse response){
        BookDao bookDao=new BookDao();
        String bid = request.getParameter("bid");
        Book book = bookDao.queryBook(bid);
        request.setAttribute("book",book);
        return "f:/jsps/book/desc.jsp";
    }

    public void searchAllCategory(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String category = request.getParameter("category");
        BookDao bookDao=new BookDao();
        List<Book> books;
        if (category.equals("全部分类")){
             books = bookDao.queryAll();
        }else {
             books = bookDao.queryByCategory(category);
        }
        JSONArray jsonArray=JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());

    }
}
