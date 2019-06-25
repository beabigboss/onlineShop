package com.lin.springbootdemo.mapper;

import com.lin.springbootdemo.model.Cart;
import com.lin.springbootdemo.model.CartTable;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CartTableMapper {
    List<Cart> selectCartable(int id);
    int deleteGoodFromCart(Map map);
    int delete(int id);
    int addToCart(int userId,int goodId,int shopnum);
    int upcart(int userId,int goodId);
    int downcart(int userId,int goodId);
}