package com.yy.study.domain;

public class Book {
    private int bid;
    private String bkname;
    private String author;
    private String price;
    private String info;
    private String src;
    private String bookType;

    public Book(int bid, String bkname, String author, String price, String info, String src, String bookType) {
        this.bid = bid;
        this.bkname = bkname;
        this.author = author;
        this.price = price;
        this.info = info;
        this.src = src;
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bkname='" + bkname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", info='" + info + '\'' +
                ", src='" + src + '\'' +
                ", bookType='" + bookType + '\'' +
                '}';
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }


    public String getSrc() {

        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Book() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
