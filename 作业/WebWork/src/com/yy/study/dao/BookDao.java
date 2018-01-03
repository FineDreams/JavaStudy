package com.yy.study.dao;

import com.yy.study.domain.Book;
import com.yy.study.util.jdbc;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    public List<Book> searchAllBook(){
        String sql="select * from books";
        Connection conn=null;
        try {
            conn= jdbc.getConnection();
            List<Book> books = new QueryRunner().query(conn, sql, new BeanListHandler<Book>(Book.class));
            return books;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public Book searchBook(String bname){
        String sql="select * from books where bkname=?";
        Connection conn=null;
        try {
            conn= jdbc.getConnection();
            Book book= new QueryRunner().query(conn, sql, new BeanHandler<Book>(Book.class),bname);
            return book;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public  int insertBook(Book book) throws SQLException {
        String sql="insert into books values(null,?,?,?)";
        Connection conn=null;
        int update=0;
        try {
            conn= jdbc.getConnection();
            update = new QueryRunner().update(
                    conn,
                    sql,
                    book.getBkname(),
                    book.getAuthor(),
                    book.getPrice()
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return update;
    }
}
