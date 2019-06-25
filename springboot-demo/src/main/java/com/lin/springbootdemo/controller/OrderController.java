package com.lin.springbootdemo.controller;

import com.lin.springbootdemo.mapper.OrderTableMapper;
import com.lin.springbootdemo.model.Order;
import com.lin.springbootdemo.model.resultList;
import com.lin.springbootdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderTableMapper orderTableMapper;
    @Autowired
    private OrderService orderService;

    /**
     * 获取所有订单
     * @return
     */
    @GetMapping("/order/all")
    @ResponseBody
    public resultList getAllOrder(){
        resultList list=new resultList();
        List<Order> orderlist=orderTableMapper.selectOrder();
        list.setCode(0);
        list.setMsg("成功");
        list.setCount(orderlist.size());
        list.setData(orderlist);
        return list;
    }
    /**
     * 用户购物，增加订单
     */
    @GetMapping("/order/add")
    @ResponseBody
    public int shopping(){
        return orderService.shopping();
    }

}
