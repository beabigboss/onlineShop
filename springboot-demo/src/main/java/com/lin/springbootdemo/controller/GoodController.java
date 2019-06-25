package com.lin.springbootdemo.controller;

import com.github.pagehelper.PageHelper;
import com.lin.springbootdemo.model.GoodsTable;
import com.lin.springbootdemo.model.metaModel.Good;
import com.lin.springbootdemo.model.resultList;
import com.lin.springbootdemo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

@Controller
public class GoodController {
    @Autowired
    private GoodService goodService;

    /**
     *
     * @return
     */
    @GetMapping("good/all")
    @ResponseBody
    public resultList getAllGood(int limit,int page){
        resultList list=new resultList();
        list.setCount(goodService.getTotalNumOfGood());
        PageHelper.startPage(page,limit);
        List goodList=goodService.getAllGood();
        if(goodList!=null){
            list.setData(goodList);
            list.setCode(0);
        }else{
            list.setCode(200);
        }
        return list;
    }
//    @GetMapping("good/all/font")
//    @ResponseBody
//    public resultList getAllGoodToFont(int limit,int curr){
//        resultList list=new resultList();
//        list.setCount(goodService.getTotalNumOfGood());
//        PageHelper.startPage(curr,limit);
//        List goodList=goodService.getAllGood();
//        if(goodList!=null){
//            list.setData(goodList);
//            list.setCode(0);
//        }else{
//            list.setCode(200);
//        }
//        return list;
//    }
    @PostMapping("good/add")
    @ResponseBody
    public String addGood(String gname, Double goprice, Double grprice, Integer gstore, String  file,Integer goodstyle_id){
        GoodsTable goodsTable=new GoodsTable();
        goodsTable.setGname(gname);
        goodsTable.setGoodstypeId(goodstyle_id);
        goodsTable.setGoprice(goprice);
        goodsTable.setGrprice(grprice);
        goodsTable.setGpicture(file);
        goodsTable.setGstore(gstore);
        System.out.println(gname+goprice+file);
        goodService.addGood(goodsTable);
        System.out.println("成功");
        //System.out.println(file.getOriginalFilename());
        return "hhhh";
    }

    /**
     * 获得一个商品的详情
     * @param goodId
     * @return
     */
    @GetMapping("/good/detail/{id}")
    @ResponseBody
    public GoodsTable getGoodDetail(@PathVariable("id") Integer goodId){
        return goodService.getGoodDetail(goodId);
    }

    /**
     * 不分页获得相同种类的商品
     * @param typeId
     * @return
     */
    @GetMapping("good/{typeId}/all")
    @ResponseBody
    public List<GoodsTable> getGoodByType(@PathVariable("typeId")Integer typeId){
        return goodService.getGoodByType(typeId);
    }
    /**
     * 分页获得相同种类的商品
     * @param typeId
     * @param limit
     * @param curr
     * @return
     */
    @GetMapping("good/{typeId}/font/all")
    @ResponseBody
    public resultList getGoodByTypeToFont(@PathVariable("typeId")Integer typeId,int limit,int curr){
        resultList List=new resultList();
        List.setCount(goodService.getTotalNumOfType(typeId));
        PageHelper.startPage(curr,limit);
        List<GoodsTable> goodList=goodService.getGoodByType(typeId);
        if(goodList!=null){
            List.setData(goodList);
            List.setCode(0);
        }else{
            List.setCode(200);
        }
        return List;
    }

    /**
     * 获得相同种类的商品有多少
     * @param typeId
     * @return
     */
    @GetMapping("/good/totalNum/{typeId}")
    @ResponseBody
    public int getTotalNumSameType(@PathVariable("typeId") int typeId){
        return goodService.getTotalNumOfType(typeId);
    }

}
