package com.lin.springbootdemo.service;

import com.lin.springbootdemo.mapper.UserMapper;
import com.lin.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User selectUserById(int id){
       return userMapper.selectUserById(id);
    }
    public List<User> selectAllUser(){
        return userMapper.selectAll();
    }
    public int updateUserStatus(int status,int id){
        return userMapper.updateStatus(status,id);
    }
    public User getUserByName(String name){
        return userMapper.selectByName(name);
    }
    public int getUserIdByName(String name){
        return userMapper.selectIdByName(name);
    }
    public int getTotalNum(){
        return userMapper.getTotalNum();
    }
}
