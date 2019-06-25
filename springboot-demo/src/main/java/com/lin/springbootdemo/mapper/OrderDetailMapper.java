package com.lin.springbootdemo.mapper;

import com.lin.springbootdemo.model.OrderDetail;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    int addTableDetail(int orderId,int goodId,int shopnum);//插入订单详情表
}