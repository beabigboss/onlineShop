package com.lin.springbootdemo.model;

public class OrderDetail {
    private Integer id;

    private Integer ordertableId;

    private Integer goodstableId;

    private Integer shoppingnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdertableId() {
        return ordertableId;
    }

    public void setOrdertableId(Integer ordertableId) {
        this.ordertableId = ordertableId;
    }

    public Integer getGoodstableId() {
        return goodstableId;
    }

    public void setGoodstableId(Integer goodstableId) {
        this.goodstableId = goodstableId;
    }

    public Integer getShoppingnum() {
        return shoppingnum;
    }

    public void setShoppingnum(Integer shoppingnum) {
        this.shoppingnum = shoppingnum;
    }
}