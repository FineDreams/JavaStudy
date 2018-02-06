package com.yy.order.domain;

public class OrderDetail {
    private int id;
    private int orders_id;//订单编号
    private int items_id;//商品编号
    private String items_num;//商品数量

    //商品对象
    private Items items;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orders_id=" + orders_id +
                ", items_id=" + items_id +
                ", items_num='" + items_num + '\'' +
                ",\n items=" + items +
                '}';
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getItems_id() {
        return items_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }

    public String getItems_num() {
        return items_num;
    }

    public void setItems_num(String items_num) {
        this.items_num = items_num;
    }
}
