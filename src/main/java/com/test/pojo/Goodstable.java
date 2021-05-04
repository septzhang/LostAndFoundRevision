package com.test.pojo;

import java.util.Date;

public class Goodstable {
    private Integer goodsId;

    private Byte goodsKinds;

    private String goodsInfo;

    private String goodsImg;

    private String goodsSite;

    private String goodsMaster;

    private String goodsContact;

    private Date goodsTime;

    private Integer goodsSuccess;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Byte getGoodsKinds() {
        return goodsKinds;
    }

    public void setGoodsKinds(Byte goodsKinds) {
        this.goodsKinds = goodsKinds;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo == null ? null : goodsInfo.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public String getGoodsSite() {
        return goodsSite;
    }

    public void setGoodsSite(String goodsSite) {
        this.goodsSite = goodsSite == null ? null : goodsSite.trim();
    }

    public String getGoodsMaster() {
        return goodsMaster;
    }

    public void setGoodsMaster(String goodsMaster) {
        this.goodsMaster = goodsMaster == null ? null : goodsMaster.trim();
    }

    public String getGoodsContact() {
        return goodsContact;
    }

    public void setGoodsContact(String goodsContact) {
        this.goodsContact = goodsContact == null ? null : goodsContact.trim();
    }

    public Date getGoodsTime() {
        return goodsTime;
    }

    public void setGoodsTime(Date goodsTime) {
        this.goodsTime = goodsTime;
    }

    public Integer getGoodsSuccess() {
        return goodsSuccess;
    }

    public void setGoodsSuccess(Integer goodsSuccess) {
        this.goodsSuccess = goodsSuccess;
    }
}