package com.yy.bookstore.category.service;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.category.dao.CategoryDao;
import com.yy.bookstore.category.domain.Category;

import java.util.List;

public class CategoryService{
    public List<Category> findAllCategory(){
        CategoryDao categoryDao=new CategoryDao();
        List<Category> categories = categoryDao.queryAllCategory();
        return categories;
    }
}
