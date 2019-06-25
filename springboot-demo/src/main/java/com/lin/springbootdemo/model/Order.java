package com.lin.springbootdemo.model;

public class Order {
    private Integer id;
//    private String email;
    private String name;
    private Integer orderId;
    private String gname;
    private Integer grprice;
    private String gpicture;
    private Integer num;
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private String orderadress;
    private int status;

    public String getOrderadress() {
        return orderadress;
    }

    public void setOrderadress(String orderadress) {
        this.orderadress = orderadress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
