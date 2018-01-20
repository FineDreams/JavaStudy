package com.yy.bookstore.book.dao;

import com.yy.bookstore.book.domain.Book;
import com.yy.bookstore.utils.MyQueryRunner;
import com.yy.bookstore.utils.jdbc.C3POUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {


    public int queryCountAll() {
        String sql="select count(*) from book";
        Connection conn = C3POUtil.getConnection();
        long aLong=0;
        try {
            aLong = new MyQueryRunner().query(conn, sql, new ScalarHandler<Long>());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return (int) aLong;
    }
    public int queryCountCategory(String category) {
        String sql="select count(*) from book bk inner join category ct on bk.cid=ct.cid where cname=?";
        Connection conn = C3POUtil.getConnection();
        long aLong=0;
        try {
            aLong = new MyQueryRunner().query(conn, sql, new ScalarHandler<Long>(),category);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return (int) aLong;
    }

    public List<Book> queryAll(){
        String sql="select * from book";
        Connection conn = C3POUtil.getConnection();
        List<Book> books=new ArrayList<>();
        try {
            books = new MyQueryRunner().query(conn, sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return books;
    }

    public List<Book> queryAllPage(int begin,int end){
        String sql="select * from book limit "+begin+","+end;
        Connection conn = C3POUtil.getConnection();
        List<Book> books=new ArrayList<>();
        try {
            books = new MyQueryRunner().query(conn, sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return books;
    }

    public void deleteByCid(String cid){
        Connection conn = C3POUtil.getConnection();
        String sql="delete from book where cid=?";
        try {
            new MyQueryRunner().update(conn,sql,cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
    }

    public List<Book> queryByCid(String cid){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from book where cid=?";
        try {
            List<Book> books = new MyQueryRunner().query(conn, sql, new BeanListHandler<Book>(Book.class),cid);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }

    public List<Book> queryByCategoryPage(String category,int begin,int end){
        String sql="select * from book bk inner join category ct on bk.cid=ct.cid where cname=? limit "+begin+","+end;
        Connection conn = C3POUtil.getConnection();
        try {
            List<Book> books = new QueryRunner().query(conn, sql, new BeanListHandler<Book>(Book.class),category);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }
    public List<Book> queryByCategory(String category){
        String sql="select * from book bk inner join category ct on bk.cid=ct.cid where cname=?";
        Connection conn = C3POUtil.getConnection();
        try {
            List<Book> books = new QueryRunner().query(conn, sql, new BeanListHandler<Book>(Book.class),category);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }
    public Book queryBook(String bbid){
        String sql="select * from book where bid=?";
        Connection conn = C3POUtil.getConnection();
        try {
            Book book = new MyQueryRunner().query(conn, sql, new BeanHandler<Book>(Book.class), bbid);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return null;
    }
}
