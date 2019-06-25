package com.lin.springbootdemo.controller;

import com.lin.springbootdemo.mapper.ManageMapper;
import com.lin.springbootdemo.model.Manage;
import com.lin.springbootdemo.model.User;
import com.lin.springbootdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@SessionAttributes({"name","msg","theUserName"})
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ManageMapper manageMapper;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param request
     * @param map
     * @return
     */
    @PostMapping("user/login")
    @ResponseBody
    public int login(String username, String password, HttpServletRequest request,Map<String,Object> map,HttpSession session){
        User user=userService.getUserByName(username);
        if(user==null){
            map.put("msg","用户不存在");
            return 0;
        }
        else if(password.equals(user.getPassword())&&user.getStatus()!=0){
            session.setAttribute("theUserName",user.getName());
            //map.put("username",user.getName());
            return 1;
        }else if(user.getStatus()==0){
            map.put("msg","账号被锁定，请联系管理员");
            System.out.println("账号被锁定，请联系管理员");
            return 0;
        }
        else{
            session.setAttribute("theUserName",user.getName());
           return 0;
        }
    }

    /**
     * 管理员登录
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/manage/login")
    public String manageLogin(String name,String password,Map<String,Object> map,HttpSession session){
        Manage manage=manageMapper.selectByPrimaryKey(name);
        if(manage==null){
            session.setAttribute("msg","管理员账户不存在");
            return "redirect:/login.html";
        }else if(password.equals(manage.getPassword())){
            session.setAttribute("name",manage.getName());
            return "redirect:/index";
        }
        else{
            session.setAttribute("msg","密码错误");
            return "redirect:/login.html";
        }
    }
}
