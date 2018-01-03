package com.yy.study.domain;

public class Book {
    private int bid;
    private String bkname;
    private String author;
    private String price;
    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bkname='" + bkname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
    public Book(int bid, String bkname, String author, String price) {
        this.bid = bid;
        this.bkname = bkname;
        this.author = author;
        this.price = price;
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
