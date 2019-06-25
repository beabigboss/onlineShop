package com.lin.springbootdemo.util;

import java.util.List;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * linyongbin
 * 这个类暂时用不到
 * 2019/6/25
 * */
public class JsonUtils {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * @Description: 对象转json字符串
     * @Title: toJson
     * @param  Object
     * @return String
     */
    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    /**
     * @Description: json转Object
     * @Title: toObject
     * @param json
     * @param className
     * @return Object
     */
    public static Object toObject(String json, Class<?> className) {
        return JSON.parseObject(json, className);
    }

    /**
     * @Description: json转List
     * @Title: toList
     * @param json
     * @param className
     * @return List
     */
    public static List<?> toList(String json, Class<?> className) {
        return JSON.parseArray(json, className);
    }

}

