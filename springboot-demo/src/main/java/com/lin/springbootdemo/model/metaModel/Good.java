package com.lin.springbootdemo.model.metaModel;

public class Good {
    private Integer id;
    private String gname;
    private Integer goprice;//原价
    private Integer grprice;//现价
    private Integer gstore;//库存量
    private String gpicture;

    public String getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(String detailImage) {
        this.detailImage = detailImage;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    private String detailImage;
    private Integer commentId;
    public Integer getGstore() {
        return gstore;
    }

    public void setGstore(Integer gstore) {
        this.gstore = gstore;
    }

    private Integer goodstype_id;
    private String typename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getGoprice() {
        return goprice;
    }

    public void setGoprice(Integer goprice) {
        this.goprice = goprice;
    }

    public Integer getGrprice() {
        return grprice;
    }

    public void setGrprice(Integer grprice) {
        this.grprice = grprice;
    }


    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public Integer getGoodstype_id() {
        return goodstype_id;
    }

    public void setGoodstype_id(Integer goodstype_id) {
        this.goodstype_id = goodstype_id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
