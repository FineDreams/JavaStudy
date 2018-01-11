package com.yy.bookstore.admin.service;

import com.yy.bookstore.book.dao.BookDao;
import com.yy.bookstore.book.domain.Book;

import java.util.List;

public class AdminAddBookService {
    public List<Book> searchAll(){
        BookDao bookDao=new BookDao();
        List<Book> books = bookDao.queryAll();
        return books;
    }
    public Book searchByBid(String bid){
        BookDao bookDao=new BookDao();
        Book book = bookDao.queryBook(bid);
        return book;
    }
}
