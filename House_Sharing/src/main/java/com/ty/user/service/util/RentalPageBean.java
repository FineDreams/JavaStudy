package com.ty.user.service.util;

import com.ty.util.PageBean;

public class RentalPageBean extends PageBean {
    public RentalPageBean() {
    }

    public RentalPageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }
    private String place;
    private String type;

    @Override
    public String toString() {
        return "RentalPageBean{" +
                "place='" + place + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
