package com.lin.springbootdemo.model;

import java.util.Date;

public class OrderTable {
    private Integer id;

    private Integer busertableId;

    private Double amount;

    private Integer status;

    private Date orderdate;

    private String orderadress;

    public String getOrderadress() {
        return orderadress;
    }

    public void setOrderadress(String orderadress) {
        this.orderadress = orderadress;
    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
}