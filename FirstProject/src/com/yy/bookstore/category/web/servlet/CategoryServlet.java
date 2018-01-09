package com.yy.bookstore.category.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.category.dao.CategoryDao;
import com.yy.bookstore.category.domain.Category;
import com.yy.bookstore.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryService",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {
    public String findAll(HttpServletRequest request,HttpServletResponse response){
        CategoryService categoryService=new CategoryService();
        List<Category> allCategory = categoryService.findAllCategory();
        request.setAttribute("categories",allCategory);
        return "f:/jsps/left.jsp";
    }



}
