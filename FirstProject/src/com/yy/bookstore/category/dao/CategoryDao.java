package com.yy.bookstore.category.dao;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.category.domain.Category;
import com.yy.bookstore.utils.MyQueryRunner;
import com.yy.bookstore.utils.jdbc.C3POUtil;
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

}
