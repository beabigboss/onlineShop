package com.lin.springbootdemo.model;

import java.util.Date;

public class FocusTable {
    private Integer id;

    private Integer goodstableId;

    private Integer busertableId;

    private Date focustime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodstableId() {
        return goodstableId;
    }

    public void setGoodstableId(Integer goodstableId) {
        this.goodstableId = goodstableId;
    }

    public Integer getBusertableId() {
        return busertableId;
    }

    public void setBusertableId(Integer busertableId) {
        this.busertableId = busertableId;
    }

    public Date getFocustime() {
        return focustime;
    }

    public void setFocustime(Date focustime) {
        this.focustime = focustime;
    }
}