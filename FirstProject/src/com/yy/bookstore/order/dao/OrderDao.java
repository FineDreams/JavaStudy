package com.yy.bookstore.order.dao;

import com.yy.bookstore.order.domain.Order;
import com.yy.bookstore.order.domain.OrderItem;
import com.yy.bookstore.utils.MyQueryRunner;
import com.yy.bookstore.utils.jdbc.C3POUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {

    public List<Order> queryByState(int state){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from orders where state=?";
        try {
            List<Order> orders = new MyQueryRunner().query(conn, sql, new BeanListHandler<Order>(Order.class),state);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;



    }


    //查出所有的订单
    public List<Order> queryAllOrder(){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from orders";
        try {
            List<Order> orders = new MyQueryRunner().query(conn, sql, new BeanListHandler<Order>(Order.class));
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }



    //通过用户id查出所有的订单
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

    //通过订单id查出订单
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


    //通过订单id修改订单状态
    public void updateState(String oid,int state) throws SQLException {
        Connection conn = C3POUtil.getConnection();
        String sql="update orders set state=? where oid=?";
        new MyQueryRunner().update(conn, sql, state, oid);

        C3POUtil.release(conn);
    }


    //通过订单id查找订单条目
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


    //添加订单
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


    //批处将订单信息插入数据库
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


    //查出订单中所有的订单条目
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
