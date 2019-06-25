package com.lin.springbootdemo.service;

import com.lin.springbootdemo.mapper.CartTableMapper;
import com.lin.springbootdemo.mapper.OrderDetailMapper;
import com.lin.springbootdemo.mapper.OrderTableMapper;
import com.lin.springbootdemo.model.Cart;
import com.lin.springbootdemo.model.OrderTable;
import com.lin.springbootdemo.model.metaModel.Data;
import com.lin.springbootdemo.model.metaModel.MedalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    private CartTableMapper cartTableMapper;
    @Autowired
    private OrderTableMapper orderTableMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    /**
     * 获取某个用户的购物车
     * @param userId
     * @return
     */
    public List<Cart> getUserCart(int userId){
        return cartTableMapper.selectCartable(userId);
    }
    public int deleteGoodFromCart(int userId,int goodId){
        Map map=new HashMap();
        map.put("userId",userId);
        map.put("goodId",goodId);
        cartTableMapper.deleteGoodFromCart(map);
        return 1;
    }
    public int addGoodToCart(int userId,int goodId,int shopnum){
        return cartTableMapper.addToCart(userId,goodId,shopnum);
    }
    /**
     * 结算订单（插入订单表，插入订单详情表，删除购物车）
     */
    public int buyGood(MedalData data){
        int id,num,price;
        /*
           插入订单表
         */
        try {

            OrderTable order = new OrderTable();
            order.setOrderdate(new Date());
            order.setBusertableId(data.getUserId());
            order.setOrderadress("广东省深圳市福田区");
            order.setAmount(data.getTotalMoney());
            order.setStatus(1);
            orderTableMapper.addOrder(order);
        /*
        插入订单详情表
         */
            int nearOrderId = orderTableMapper.getNearOrderId(data.getUserId());
            for (int i = 0; i < data.getData().size(); i++) {
                id = data.getData().get(i).getId();
                num = data.getData().get(i).getNum();
                orderDetailMapper.addTableDetail(nearOrderId, id, num);
            }
        /*
        删除购物车相应物品
         */
            for (int i = 0; i < data.getData().size(); i++) {
                this.deleteGoodFromCart(data.getUserId(),data.getData().get(i).getId());
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return 1;
    }
    public int upCart(int userId,int goodId){
        return cartTableMapper.upcart(userId,goodId);
    }
    public int downCart(int userId,int goodId){
        return cartTableMapper.downcart(userId,goodId);
    }
}
