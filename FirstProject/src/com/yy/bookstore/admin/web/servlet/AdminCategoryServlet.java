package com.yy.bookstore.admin.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.admin.service.AdminService;
import com.yy.bookstore.admin.service.exception.*;
import com.yy.bookstore.book.service.BookService;
import com.yy.bookstore.category.dao.CategoryDao;
import com.yy.bookstore.category.domain.Category;
import com.yy.bookstore.category.service.CategoryService;
import com.yy.bookstore.utils.system.SysMake;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminCategoryServlet",urlPatterns = "/admin")
public class AdminCategoryServlet extends BaseServlet {
    public String findAll(HttpServletRequest request,HttpServletResponse response){
        CategoryService categoryService=new CategoryService();
        List<Category> allCategory = categoryService.findAllCategory();
        request.setAttribute("allCategory",allCategory);
        return "f:/adminjsps/admin/category/list.jsp";
    }

    public String add(HttpServletRequest request,HttpServletResponse response){
        Map<String, String[]> parameterMap = request.getParameterMap();
        AdminService adminService=new AdminService();
        Category fromCategory=new Category();
        try {
            BeanUtils.populate(fromCategory,parameterMap);
            fromCategory.setCid(new SysMake().randomOid());
            adminService.addCategory(fromCategory);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (OperateException e) {
            request.setAttribute("operateMsg",e.getMessage());
            return "f:/adminjsps/admin/category/add.jsp";
        }
        return "f:/adminjsps/admin/category/add.jsp";
    }

    public String delete(HttpServletRequest request,HttpServletResponse response){
        String cid = request.getParameter("cid");
        CategoryDao categoryDao=new CategoryDao();
        Category category = categoryDao.queryByCid(cid);
        request.setAttribute("category",category);
        AdminService adminService=new AdminService();
        try {
            adminService.deleteCategory(cid);
        } catch (OperateException e) {
            request.setAttribute("operateMsg",e.getMessage());
            return "f:/adminjsps/admin/category/del.jsp";
        }
        return "f:/adminjsps/admin/category/del.jsp";
    }

    public String editPre(HttpServletRequest request,HttpServletResponse response){
        String cid=request.getParameter("cid");
        CategoryDao categoryDao=new CategoryDao();
        String cname = request.getParameter("cname");
        Category category = categoryDao.queryByCid(cid);
        request.setAttribute("category",category);
        AdminService adminService=new AdminService();
        try {
            adminService.editCategory(cid,cname);
        } catch (NotNoneException e) {
            request.setAttribute("operateMsg",e.getMessage());
            return "f:/adminjsps/admin/category/mod.jsp";
        }
        return "f:/adminjsps/admin/category/mod.jsp";
    }

}
