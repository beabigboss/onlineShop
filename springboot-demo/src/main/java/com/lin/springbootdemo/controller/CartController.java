package com.lin.springbootdemo.controller;
import com.lin.springbootdemo.mapper.CartTableMapper;
import com.lin.springbootdemo.model.Cart;
import com.lin.springbootdemo.model.metaModel.MedalData;
import com.lin.springbootdemo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class CartController {
    @Autowired
    private CartTableMapper cartTableMapper;
    @Autowired
    private CartService cartService;

    /**
     * 获取用户购物车
     * @param
     * @return
     */
    @GetMapping("user/{id}/cart/delete/{goodId}")
    @ResponseBody
    public int deleteGoodFromCart(@PathVariable("id") int userId,@PathVariable("goodId") int goodId){

        return cartService.deleteGoodFromCart(userId,goodId);
    }
    @GetMapping("user/cart/{id}")
    @ResponseBody
    public UserCartInfo getUserCart(@PathVariable("id") Integer id){
        UserCartInfo userCartInfo=new UserCartInfo();
        userCartInfo.setInfoList(cartTableMapper.selectCartable(id));
        userCartInfo.setStatus(0);
        return userCartInfo;
    }
    @GetMapping("user/addCart/{userId}/{goodId}/{num}")
    @ResponseBody
    public int addcart(@PathVariable("userId") int userId,@PathVariable("goodId") int goodId,@PathVariable("num") int num){
        return cartService.addGoodToCart(userId,goodId,num);
    }
    @GetMapping("delete")
    @ResponseBody
    public String delete(){
        cartTableMapper.delete(60003);
       return "s";
    }
    @GetMapping("cart/up/good/{goodId}/{userId}")
    @ResponseBody
    public int upcart(@PathVariable("goodId") Integer goodId,@PathVariable("userId") Integer userId){

        return cartService.upCart(userId,goodId);
    }
    @GetMapping("cart/down/good/{goodId}/{userId}")
    @ResponseBody
    public int downcart(@PathVariable("goodId") Integer goodId,@PathVariable("userId") Integer userId){

        return cartService.downCart(userId,goodId);
    }
    /**
     * 用户结算
     * @param datalist
     * @return
     */
    @PostMapping("user/buy")
    @ResponseBody
    public int userBuyGood(@RequestBody MedalData datalist){
        System.out.println(datalist.getUserId());
        cartService.buyGood(datalist);
        return 1;
    }
    public class UserCartInfo{
        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }


        public List<Cart> getInfoList() {
            return infoList;
        }

        public void setInfoList(List<Cart> infoList) {
            this.infoList = infoList;
        }

        private Integer status;
        private List<Cart> infoList;
    }
}
