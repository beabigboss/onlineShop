package com.lin.springbootdemo.model.metaModel;

public class Data{
    private Integer id;
    private Integer price;
    private String name;
    private Integer num;
    private String goodimage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", goodimage='" + goodimage + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodimage() {
        return goodimage;
    }

    public void setGoodimage(String goodimage) {
        this.goodimage = goodimage;
    }



    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


}