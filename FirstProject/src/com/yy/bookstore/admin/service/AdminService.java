package com.yy.bookstore.admin.service;

import com.yy.bookstore.admin.service.exception.*;
import com.yy.bookstore.book.dao.BookDao;
import com.yy.bookstore.book.domain.Book;
import com.yy.bookstore.category.dao.CategoryDao;
import com.yy.bookstore.category.domain.Category;

import java.util.List;

public class AdminService {
    public void addCategory(Category fromCategory) throws AddFailedException, AddSuccessException {
        CategoryDao categoryDao=new CategoryDao();
        int i = categoryDao.updateCategory(fromCategory);
        if (i==0){
            throw new AddFailedException();
        }
        if (i>0){
            throw new AddSuccessException();
        }
    }

    public void deleteCategory(String cid) throws DeleteFailedException, DeleteSuccessException, HaveBookException {
        CategoryDao categoryDao=new CategoryDao();
        BookDao bookDao=new BookDao();
        List<Book> books = bookDao.queryByCid(cid);
        if (books==null){
            categoryDao.deleteCategory(cid);
        }
        if (books!=null){
            bookDao.deleteByCid(cid);
            categoryDao.deleteCategory(cid);
        }
    }
    public void editCategory(String cid,String cname) throws NotNoneException {
        CategoryDao categoryDao=new CategoryDao();
        if (cname==null){
            throw new NotNoneException();
        }
        categoryDao.modifyCategory(cid,cname);
    }



}
