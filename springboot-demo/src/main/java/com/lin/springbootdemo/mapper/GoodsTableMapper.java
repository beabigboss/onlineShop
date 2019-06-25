package com.lin.springbootdemo.mapper;

import com.lin.springbootdemo.model.GoodsTable;

import java.util.List;

import com.lin.springbootdemo.model.metaModel.Good;
import org.apache.ibatis.annotations.Param;

public interface GoodsTableMapper {
    List<Good> selectAllGood();
    List<GoodsTable> selectGoodWithSameType(int typeId);
    int addGood(GoodsTable goodsTable);
    GoodsTable getGoodDetail(int id);
    int getTotalNum();
    int getTotalNumWithSameType(int typeId);//获得某个种类的商品总数有多少
}