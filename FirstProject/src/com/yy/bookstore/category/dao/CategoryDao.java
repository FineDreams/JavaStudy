package com.yy.bookstore.category.dao;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.category.domain.Category;
import com.yy.bookstore.utils.MyQueryRunner;
import com.yy.bookstore.utils.jdbc.C3POUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao{
    public List<Category> queryAllCategory(){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from category";
        try {
            List<Category> categorys = new MyQueryRunner().query(conn, sql, new BeanListHandler<Category>(Category.class));
            return categorys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateCategory(Category category){
        Connection conn = C3POUtil.getConnection();
        String sql="insert into category values (?,?)";
        try {
            int update = new MyQueryRunner().update(conn, sql, category.getCid(), category.getCname());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
        return 0;
    }

    public int deleteCategory(String cid){
        Connection conn = C3POUtil.getConnection();
        String sql="delete from category where cid=?";
        try {
            int update = new MyQueryRunner().update(conn, sql, cid);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void modifyCategory(String cid,String cname){
        Connection conn = C3POUtil.getConnection();
        String sql="update category set cname=? where cid=?";
        try {
            new MyQueryRunner().update(conn,sql,cname,cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3POUtil.release(conn);
        }
    }

    public Category  queryByCid(String cid){
        Connection conn = C3POUtil.getConnection();
        String sql="select * from category where cid=?";
        try {
            Category category = new MyQueryRunner().query(conn, sql, new BeanHandler<Category>(Category.class), cid);
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
