package com.ty.user.domain;

import java.util.Date;

public class Rental {
    private Integer rid;

    private String type;

    private String place;

    private Double price;

    private String info;

    private Date lenddate;

    private String state;

    private Double area;

    private Integer uid;

    private User user;

    public Rental(Integer rid, String type, String place, Double price, String info, Date lenddate, String state, Double area, Integer uid) {
        this.rid = rid;
        this.type = type;
        this.place = place;
        this.price = price;
        this.info = info;
        this.lenddate = lenddate;
        this.state = state;
        this.area = area;
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rid=" + rid +
                ", type='" + type + '\'' +
                ", place='" + place + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", lenddate=" + lenddate +
                ", state='" + state + '\'' +
                ", area=" + area +
                ", uid=" + uid +
                '}';
    }

    public Rental() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Date getLenddate() {
        return lenddate;
    }

    public void setLenddate(Date lenddate) {
        this.lenddate = lenddate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}