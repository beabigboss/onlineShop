package com.lin.springbootdemo.controller;

import com.github.pagehelper.PageHelper;
import com.lin.springbootdemo.service.UserService;
import com.lin.springbootdemo.model.User;
import com.lin.springbootdemo.model.resultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询某个用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") int id){
        return userService.selectUserById(id);
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("user/all")
    @ResponseBody
    public resultList getAllUser(int limit,int page){
        resultList list=new resultList();
        list.setCode(0);
        list.setCount(userService.getTotalNum());
        list.setMsg("");
        PageHelper.startPage(page,limit);
        List<User> list1=userService.selectAllUser();
        list.setData(list1);
        return list;
    }

    /**
     * 修改用户状态
     * @param userId
     * @param status
     * @return
     */
    @GetMapping("user/{id}/status/update/{status}")
    @ResponseBody
    public int updateUserStatus(@PathVariable("id") int userId,@PathVariable("status") int status){
        return userService.updateUserStatus(status,userId);
    }
    /**
     * 得到用户的id,根据用户姓名
     */
    @GetMapping("user/getByName/{name}")
    @ResponseBody
    public int getUserIdByName(@PathVariable("name") String name){
        return userService.getUserIdByName(name);
    }
}
