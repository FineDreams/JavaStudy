package com.yy.bookstore.book.domain;

import java.util.List;

public class PageBean {
    private List<Book> books;
    private int pageCode;//当前页码
    private int totalData;//从数据库查询总数据
    private int totalPages;//数据总条数
    private int pageSize=4;//一个页面显示多少条数据


    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalPages() {
        int number= totalData / pageSize;
        if (totalData%pageSize>0){
            number++;
        }
        return number;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "books=" + books +
                ", pageCode=" + pageCode +
                ", totalData=" + totalData +
                ", totalPages=" + totalPages +
                ", pageSize=" + pageSize +
                '}';
    }

    public PageBean(List<Book> books, int pageCode, int totalData, int totalPages, int pageSize) {
        this.books = books;
        this.pageCode = pageCode;
        this.totalData = totalData;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
    }

    public PageBean() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
