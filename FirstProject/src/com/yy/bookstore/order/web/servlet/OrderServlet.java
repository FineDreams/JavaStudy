package com.yy.bookstore.order.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.book.dao.BookDao;
import com.yy.bookstore.book.domain.Book;
import com.yy.bookstore.cart.domain.Cart;
import com.yy.bookstore.cart.domain.CartItem;
import com.yy.bookstore.order.dao.OrderDao;
import com.yy.bookstore.order.domain.Order;
import com.yy.bookstore.order.domain.OrderItem;
import com.yy.bookstore.order.service.OrderService;
import com.yy.bookstore.order.service.exception.OrderException;
import com.yy.bookstore.user.domain.User;
import com.yy.bookstore.utils.system.SysMake;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order=new Order();
        OrderService orderService=new OrderService();
        OrderDao orderDao=new OrderDao();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        Map<String, CartItem> cartItemMap = cart.getCartItemMap();
        List<OrderItem> orderItemList=new ArrayList<>();
        OrderItem orderItem=null;
        double total=0;
        order.setOid(new SysMake().randomOid());
        for (Map.Entry<String, CartItem> entry : cartItemMap.entrySet()) {
            orderItem=new OrderItem();
            CartItem cartItem = entry.getValue();
            Book book = cartItem.getBook();

            orderItem.setBook(book);
            String c = cartItem.getCount();
            int count=Integer.parseInt(c);
            orderItem.setCount(count);
            orderItem.setOid(order.getOid());
            orderItem.setIid(UUID.randomUUID().toString().replaceAll("-",""));
            orderItem.setBid(book.getBid());
            double sub = book.getPrice() * count;
            orderItem.setSubtotal(sub);
//            orderDao.addOrderItem(orderItem);
            orderItemList.add(orderItem);
            total+=sub;
        }
        session.setAttribute("cart",new Cart());
        order.setOrderItemList(orderItemList);
        order.setOrdertime(new SysMake().sysTime());
        order.setUid(user.getUid());
        order.setTotal(total);
        order.setState(3);
        orderDao.addOrder(order);
        request.setAttribute("order",order);
        List<Order> orders = orderService.add(order);
        orderDao.addOrderItemList(orderItemList);
       request.setAttribute("orderItemList",orderItemList);
        return "f:/jsps/order/desc.jsp";
    }
    public String myOrders(HttpServletRequest request,HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        BookDao bookDao=new BookDao();
        OrderDao orderDao=new OrderDao();
        String uid = user.getUid();
        List<Order> orderList = orderDao.queryByUid(uid);

        for (Order order : orderList) {
            String oid = order.getOid();
            List<OrderItem> orderItemList = orderDao.queryByOid(oid);
            for (OrderItem orderItem : orderItemList) {
                String bid = orderItem.getBid();
                Book book = bookDao.queryBook(bid);
                orderItem.setBook(book);
            }
            order.setOrderItemList(orderItemList);
        }
        request.setAttribute("orderList",orderList);
        return "f:/jsps/order/list.jsp";
    }

    public String load(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        OrderDao orderDao=new OrderDao();
        Order order = orderDao.queryByOidFromOds(oid);
        request.setAttribute("order",order);
        BookDao bookDao=new BookDao();
        List<OrderItem> orderItemList = orderDao.queryByOid(oid);
        for (OrderItem orderItem : orderItemList) {
            String bid = orderItem.getBid();
            Book book = bookDao.queryBook(bid);
            orderItem.setBook(book);
        }
        request.setAttribute("orderItemList",orderItemList);
        return "f:/jsps/order/desc.jsp";
    }

    public String confirm(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        OrderService orderService=new OrderService();
        try {
            orderService.confirm(oid);
        } catch (OrderException e) {
            request.setAttribute("stateMsg",e.getMessage());
            return "f:/jsps/order/msg.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "f:/jsps/order/msg.jsp";
    }


}
