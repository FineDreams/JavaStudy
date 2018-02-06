package com.yy.order.domain;

import com.yy.domain.User;

import java.util.Date;
import java.util.List;

public class Orders {
    private int id;
    private String number;//订单编号
    private int user_id;//用户id
    private Date createtime;//订单创建时间
    private String note;//备注
    //用户信息
    private User user;
    //订单明细
    private List<OrderDetail> detailList;

    public List<OrderDetail> getDetailList() {
        return detailList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user_id=" + user_id +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", \ndetailList=" + detailList +
                '}';
    }

    public void setDetailList(List<OrderDetail> detailList) {
        this.detailList = detailList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orders() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Orders(int id, String number, Date createtime, String note) {
        this.id = id;
        this.number = number;
        this.createtime = createtime;
        this.note = note;
    }
}
