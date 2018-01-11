package com.yy.bookstore.cart.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.book.dao.BookDao;
import com.yy.bookstore.book.domain.Book;
import com.yy.bookstore.cart.domain.Cart;
import com.yy.bookstore.cart.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        Map<String, CartItem> cartltemMap = new HashMap<>();
        if (cart!=null){
            cartltemMap = cart.getCartItemMap();
        }
        BookDao bookDao=new BookDao();
        String bid = request.getParameter("bid");
        String count = request.getParameter("count");
        Book book = bookDao.queryBook(bid);
        CartItem cartItem =new CartItem(book,count);
        cartltemMap.put(bid, cartItem);
         new Cart(cartltemMap);
        request.getSession().setAttribute("cart",cart);
        return "f:/jsps/cart/list.jsp";
    }

    public String clear(HttpServletRequest request, HttpServletResponse response){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        return "f:/jsps/cart/list.jsp";
    }
    public String delete(HttpServletRequest request, HttpServletResponse response){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String bid = request.getParameter("bid");
        cart.delete(bid);
        return "f:/jsps/cart/list.jsp";
    }

}
