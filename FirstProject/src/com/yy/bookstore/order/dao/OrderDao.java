package com.yy.bookstore.order.dao;

import com.yy.bookstore.cart.domain.Cart;
import com.yy.bookstore.cart.domain.CartItem;
import com.yy.bookstore.order.domain.Order;
import com.yy.bookstore.order.domain.OrderItem;
import com.yy.bookstore.utils.MyQueryRunner;
import com.yy.bookstore.utils.jdbc.C3POUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderDao {
    public List<Order> queryByUid(String Uid){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from orders where uid=?";
        try {
            List<Order> orders = new MyQueryRunner().query(conn, sql, new BeanListHandler<Order>(Order.class),Uid);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }
    public Order queryByOidFromOds(String oid){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from orders where oid=?";
        try {
            Order order= new MyQueryRunner().query(conn, sql, new BeanHandler<Order>(Order.class),oid);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }

//    public int getStateByOid(String oid){
//        Connection conn = C3POUtil.getConnection();
//        String sql="select state from orders where oid=?";
//        try {
//            Integer state = new MyQueryRunner().query(conn, sql, new ScalarHandler<>());
//            return state;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            C3POUtil.release(conn);
//        }
//        return 0;
//    }
    public void updateState(String oid,int state) throws SQLException {
        Connection conn = C3POUtil.getConnection();
        String sql="update orders set state=? where oid=?";
        new MyQueryRunner().update(conn, sql, state, oid);

        C3POUtil.release(conn);
    }

    public List<OrderItem> queryByOid(String Oid){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from orderitem where oid=?";
        try {
            List<OrderItem> orderItems = new MyQueryRunner().query(conn, sql, new BeanListHandler<OrderItem>(OrderItem.class), Oid);
            return orderItems;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }


    public void addOrder(Order order){
        Connection conn = C3POUtil.getConnection();
        String sql="insert into orders values(?,?,?,?,?,?)";
        try {
            new MyQueryRunner().update(conn,sql
                    ,order.getOid()
                    ,order.getOrdertime()
                    ,order.getTotal()
                    ,order.getState()
                    ,order.getUid()
                    ,order.getAddress()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
    }

    public void addOrderItemList(List<OrderItem> orderItemList){
        Connection conn = C3POUtil.getConnection();
        PreparedStatement prepst=null;
        try {
            prepst = conn.prepareStatement("INSERT  INTO orderitem VALUES (?,?,?,?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (OrderItem orderItem:orderItemList) {
            try {
                prepst.setString(1,orderItem.getIid());
                prepst.setInt(2,orderItem.getCount());
                prepst.setInt(3, (int) orderItem.getSubtotal());
                prepst.setString(4,orderItem.getOid());
                prepst.setString(5,orderItem.getBid());
                prepst.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        try {
            prepst.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        C3POUtil.release(conn,prepst);
    }
//    public void addOrderItem(OrderItem orderItem){
//        Connection conn = C3POUtil.getConnection();
//        String sql="insert into orderitem values (?,?,?,?,?)";
//        try {
//            new MyQueryRunner().update(conn,sql,
//                    orderItem.getIid(),
//                    orderItem.getCount(),
//                    orderItem.getSubtotal(),
//                    orderItem.getOid(),
//                    orderItem.getBid()
//                    );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            C3POUtil.release(conn);
//        }
//    }



    public List<OrderItem> queryOrderItemList(){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from orderitem";
        try {
            List<OrderItem> orderItems = new MyQueryRunner().query(conn, sql, new BeanListHandler<OrderItem>(OrderItem.class));
            return orderItems;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }

}
