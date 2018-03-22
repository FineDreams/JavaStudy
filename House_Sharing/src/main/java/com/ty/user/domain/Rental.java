package com.ty.user.domain;

import java.util.Date;

public class Rental {
    private Integer rid;

    private String type;

    private String place;

    private String region;

    private Double price;

    private String info;

    private Date lenddate;

    private String state;

    public Rental(Integer rid, String type, String place, String region, Double price, String info, Date lenddate, String state) {
        this.rid = rid;
        this.type = type;
        this.place = place;
        this.region = region;
        this.price = price;
        this.info = info;
        this.lenddate = lenddate;
        this.state = state;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
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
}