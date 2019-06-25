package com.lin.springbootdemo.model;
public class Cart {
    private Integer id;//购物车中行id
    private String name;
    private Integer shoppingnum;
    private String gname;
    private Integer grprice;
    private String gpicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShoppingnum() {
        return shoppingnum;
    }

    public void setShoppingnum(Integer shoppingnum) {
        this.shoppingnum = shoppingnum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getGrprice() {
        return grprice;
    }

    public void setGrprice(Integer grprice) {
        this.grprice = grprice;
    }


}
