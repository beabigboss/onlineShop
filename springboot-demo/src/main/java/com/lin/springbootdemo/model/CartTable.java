package com.lin.springbootdemo.model;

public class CartTable {
    private Integer id;

    private Integer busertableId;

    private Integer goodstableId;

    private Integer shoppingnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusertableId() {
        return busertableId;
    }

    public void setBusertableId(Integer busertableId) {
        this.busertableId = busertableId;
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