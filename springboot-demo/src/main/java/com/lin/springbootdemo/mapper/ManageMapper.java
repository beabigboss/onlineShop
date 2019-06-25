package com.lin.springbootdemo.mapper;

import com.lin.springbootdemo.model.Manage;

public interface ManageMapper {
    int deleteByPrimaryKey(String name);

    int insert(Manage record);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
}