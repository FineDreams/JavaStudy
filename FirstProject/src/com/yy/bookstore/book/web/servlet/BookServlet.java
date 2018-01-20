package com.yy.bookstore.book.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.book.dao.BookDao;
import com.yy.bookstore.book.domain.Book;
import com.yy.bookstore.book.domain.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
        String code = request.getParameter("pageCode");
//        System.out.println(code+"--------------111111111");//11111111111111
        PageBean pageBean=new PageBean();
        BookDao bookDao=new BookDao();
        if (code==null||code.equals("1")){
            code="1";
        }
        int bg = Integer.parseInt(code);
        int begin=(bg-1)*pageBean.getPageSize();
//        System.out.println(begin+"-----------222222");//2222222222
        int end=pageBean.getPageSize();
        pageBean.setPageCode(bg);
        List<Book> books;
        int count;
//        System.out.println(category+"----------33333333333");
        if (category.equals("全部分类")){
//            System.out.println(category+"------------44444");//44444
            books = bookDao.queryAllPage(begin,end);
//            System.out.println(books+"-------------5555555");//5555555
            count = bookDao.queryCountAll();
//            System.out.println(count+"--------------66666666");//66666666
        }else {
             books = bookDao.queryByCategoryPage(category,begin,end);
            count = bookDao.queryCountCategory(category);
        }
        pageBean.setTotalData(count);
        pageBean.setBooks(books);
//        System.out.println(pageBean.toString()+"------------------777777777");//777777777
//        System.out.println(pageBean.getBooks()+"--------------8888888888");//8888888888
        JSONObject jsonArray=JSONObject.fromObject(pageBean);
        response.getWriter().write(jsonArray.toString());

    }
}
