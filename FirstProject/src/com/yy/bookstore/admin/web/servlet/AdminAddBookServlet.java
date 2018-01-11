package com.yy.bookstore.admin.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.admin.service.AdminAddBookService;
import com.yy.bookstore.book.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminAddBookServlet",urlPatterns = "/addBook")
public class AdminAddBookServlet extends BaseServlet {

    public String findAll(HttpServletRequest request,HttpServletResponse response){
        AdminAddBookService adminAddBookService=new AdminAddBookService();
        List<Book> books = adminAddBookService.searchAll();
        request.setAttribute("books",books);
        return "f:/adminjsps/admin/book/list.jsp";
    }

    public String load(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        AdminAddBookService adminAddBookService=new AdminAddBookService();
        Book book = adminAddBookService.searchByBid(bid);
        request.setAttribute("book",book);
        return "f:/adminjsps/admin/book/desc.jsp";
    }

}
