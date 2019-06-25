package com.lin.springbootdemo.mapper;

import com.lin.springbootdemo.model.User;

import java.util.List;


public interface UserMapper {
    User selectUserById(int id);
    List<User> selectAll();
    int updateStatus(int status,int id);
    User selectByName(String name);
    int selectIdByName(String name);
    int getTotalNum();
}