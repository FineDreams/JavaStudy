package com.yy.bookstore.admin.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.book.dao.BookDao;
import com.yy.bookstore.book.domain.Book;
import com.yy.bookstore.order.dao.OrderDao;
import com.yy.bookstore.order.domain.Order;
import com.yy.bookstore.order.domain.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderManagerServlet",urlPatterns = "/orderManager")
public class OrderManagerServlet extends BaseServlet {
   private OrderDao orderDao=new OrderDao();
   private BookDao bookDao=new BookDao();
    public String showAll(HttpServletRequest request,HttpServletResponse response){
//        OrderDao orderDao=new OrderDao();
        List<Order> orders = orderDao.queryAllOrder();
        for (Order order : orders) {
            String oid = order.getOid();
            List<OrderItem> orderItemList = orderDao.queryByOid(oid);
            for (OrderItem orderItem : orderItemList) {
                String bid = orderItem.getBid();
                Book book = bookDao.queryBook(bid);
                orderItem.setBook(book);
            }
            order.setOrderItemList(orderItemList);
        }
        request.setAttribute("orders",orders);
        return "f:/adminjsps/admin/order/list.jsp";
    }
    public String notPay(HttpServletRequest request,HttpServletResponse response){
        //状态3表示未付款
        List<Order> orders = orderDao.queryByState(3);
        for (Order order : orders) {
            String oid = order.getOid();
            List<OrderItem> orderItemList = orderDao.queryByOid(oid);
            for (OrderItem orderItem : orderItemList) {
                String bid = orderItem.getBid();
                Book book = bookDao.queryBook(bid);
                orderItem.setBook(book);
            }
            order.setOrderItemList(orderItemList);
        }
        System.out.println(orders.toString());
        request.setAttribute("orders",orders);

        return "f:/adminjsps/admin/order/list.jsp";
    }


    public String alreadyPay(HttpServletRequest request,HttpServletResponse response){
        List<Order> orders = orderDao.queryByState(4);
        for (Order order : orders) {
            String oid = order.getOid();
            List<OrderItem> orderItemList = orderDao.queryByOid(oid);
            for (OrderItem orderItem : orderItemList) {
                String bid = orderItem.getBid();
                Book book = bookDao.queryBook(bid);
                orderItem.setBook(book);
            }
            order.setOrderItemList(orderItemList);
        }
        System.out.println(orders.toString());
        request.setAttribute("orders",orders);
        return "f:adminjsps/admin/order/list.jsp";
    }

    public String unCollected(HttpServletRequest request,HttpServletResponse response){
        List<Order> orders = orderDao.queryByState(5);
        for (Order order : orders) {
            String oid = order.getOid();
            List<OrderItem> orderItemList = orderDao.queryByOid(oid);
            for (OrderItem orderItem : orderItemList) {
                String bid = orderItem.getBid();
                Book book = bookDao.queryBook(bid);
                orderItem.setBook(book);
            }
            order.setOrderItemList(orderItemList);
        }
        System.out.println(orders.toString());
        request.setAttribute("orders",orders);
        return "f:adminjsps/admin/order/list.jsp";
    }

    public String completed(HttpServletRequest request,HttpServletResponse response){
        List<Order> orders = orderDao.queryByState(6);
        for (Order order : orders) {
            String oid = order.getOid();
            List<OrderItem> orderItemList = orderDao.queryByOid(oid);
            for (OrderItem orderItem : orderItemList) {
                String bid = orderItem.getBid();
                Book book = bookDao.queryBook(bid);
                orderItem.setBook(book);
            }
            order.setOrderItemList(orderItemList);
        }
        System.out.println(orders.toString());
        request.setAttribute("orders",orders);
        return "f:adminjsps/admin/order/list.jsp";
    }




}
