package com.lin.springbootdemo.service;

import com.lin.springbootdemo.mapper.GoodsTableMapper;
import com.lin.springbootdemo.model.GoodsTable;
import com.lin.springbootdemo.model.metaModel.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    @Autowired
    private GoodsTableMapper goodsTableMapper;
    public List<Good> getAllGood(){
        return goodsTableMapper.selectAllGood();
    }
    public Integer addGood(GoodsTable goodsTable){
        return goodsTableMapper.addGood(goodsTable);
    }
    public GoodsTable getGoodDetail(int id){
        return goodsTableMapper.getGoodDetail(id);
    }
    public List<GoodsTable> getGoodByType(Integer typeId){
        return goodsTableMapper.selectGoodWithSameType(typeId);
    }

    /**
     *获得商品表的总数
     * @return
     */
    public int getTotalNumOfGood(){
        return goodsTableMapper.getTotalNum();
    }

    /**
     * 获得某个种类的商品总数有多少
     * @param typeId
     * @return
     */
    public int getTotalNumOfType(int typeId){
        return goodsTableMapper.getTotalNumWithSameType(typeId);
    }
}
