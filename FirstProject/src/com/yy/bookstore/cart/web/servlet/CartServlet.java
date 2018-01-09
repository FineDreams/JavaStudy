package com.yy.bookstore.cart.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.book.dao.BookDao;
import com.yy.bookstore.book.domain.Book;
import com.yy.bookstore.cart.domain.Cart;
import com.yy.bookstore.cart.domain.Cartltem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        Map<String, Cartltem> cartltemMap = new HashMap<>();
        if (cart!=null){
            cartltemMap = cart.getCartltemMap();
        }
        BookDao bookDao=new BookDao();
        String bid = request.getParameter("bid");
        String count = request.getParameter("count");
        Book book = bookDao.queryBook(bid);
        Cartltem cartltem=new Cartltem(book,count);
        cartltemMap.put(bid,cartltem);
         new Cart(cartltemMap);
        request.getSession().setAttribute("cart",cart);
        return "f:/jsps/cart/list.jsp";
    }
}
