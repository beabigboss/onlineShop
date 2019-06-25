package com.lin.springbootdemo.model.metaModel;

import java.util.List;

/**
 * 中间类，用来映射前端返回用户购买的东西，用户id，总钱数等
 */
public class MedalData {
    private Integer userId;

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    private Double totalMoney;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private List<Data> data;


    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
