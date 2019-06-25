package com.lin.springbootdemo;

import com.lin.springbootdemo.controller.CartController;
import com.lin.springbootdemo.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

    @Test
    public void contextLoads() {
    }
//    @Test
//    public void test(){
//        String s="[{ name: '2包邮1KG装新西兰兰维乐进口鲜活特大青口贝半壳新鲜冷冻贝熟冻', id: 40012, num: 3,price:60 }]";
//        System.out.println(s);
//        ArrayList<CartController.Data> list= (ArrayList<CartController.Data>) JsonUtils.toList(s, CartController.Data.class);
//        System.out.println(list);
//    }

}
