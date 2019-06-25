package com.lin.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes({"hello","name"})
public class testController {
    @GetMapping("/lin")
    public String hello(Map<String,Object> map){
        map.put("name","linyongbin");
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @PostMapping("upload/image")
    @ResponseBody
    public Map<String,Object> uploadImage(MultipartFile file) {
        String filename=file.getOriginalFilename();
//        String suffixname=filename.substring(filename.lastIndexOf("."));
//        filename= UUID.randomUUID()+suffixname;
        String filepath="C:/mydata/upload/image/";


        try {
            file.transferTo(new File(filepath + filename));


        }catch(Exception e){
            e.printStackTrace();

        }
        System.out.println(file.getOriginalFilename());
        Map<String, Object> map = new HashMap<>();
        map.put("code","0");
        return map;
    }
//    class Respon{
//        private int count;
//
//    }
//    /**
//     * 测试layui分页
//     */
    @GetMapping("test/layui")
    @ResponseBody
    public int test(int curr,int limit){

        System.out.println("当前页是"+curr);
        System.out.println("每页条数是"+limit);
        return 1;
    }

}
