package com.lin.springbootdemo.mapper;

import com.lin.springbootdemo.model.Order;
import com.lin.springbootdemo.model.OrderTable;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderTableMapper {

    List<Order> selectOrder();
    Integer addOrder(OrderTable orderTable);
    Integer getNearOrderId(Integer userId);//获得用户最近一个订单的id，用于插入订单详情表
}