package com.lin.springbootdemo.service;

import com.lin.springbootdemo.mapper.OrderTableMapper;
import com.lin.springbootdemo.model.Order;
import com.lin.springbootdemo.model.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderTableMapper orderTableMapper;
//    public int shopping(List<Order> order,String adress,Integer id){
////        int size=order.size();
//        Double totalMoney=0.0;//总价钱
////        for(int i=0;i<size;i++){
////            totalMoney+=order.get(i).getGrprice()*order.get(i).getNum();
////        }
//        System.out.println(totalMoney);
//        OrderTable orderTable=new OrderTable();
//        orderTable.setAmount(totalMoney);
//        orderTable.setOrderadress(adress);
//        orderTable.setStatus(1);
//        orderTable.setBusertableId(id);
//        orderTable.setOrderdate(new Date());
//        orderTableMapper.addOrder(orderTable);
//        return 1;
//    }
    public int shopping(){
//        int size=order.size();
        Double totalMoney=0.0;//总价钱
//        for(int i=0;i<size;i++){
//            totalMoney+=order.get(i).getGrprice()*order.get(i).getNum();
//        }
        System.out.println(totalMoney);
        OrderTable orderTable=new OrderTable();
        orderTable.setAmount(totalMoney);
        orderTable.setOrderadress("55555");
        orderTable.setStatus(1);
        orderTable.setBusertableId(10002);
        orderTable.setOrderdate(new Date());
        orderTableMapper.addOrder(orderTable);
        return 1;
    }

    /**
     * 获得某个最近一个订单的Id
     * @param userId
     * @return
     */
    public Integer getNearOrderId(Integer userId){
        return orderTableMapper.getNearOrderId(userId);
    }
}
