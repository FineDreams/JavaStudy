package com.yy.domain;

public class Article {
    private Integer goodsId;

    private String goodsName;

    private String goodsCode;

    private Integer goodsCount;

    private String fileId;

    private String sponsor;

    private String memo;

    private Integer deleteFlag;

    private Integer price;

    private Integer discount;

    private Integer type;

    public Article(Integer goodsId, String goodsName, String goodsCode, Integer goodsCount, String fileId, String sponsor, String memo, Integer deleteFlag, Integer price, Integer discount, Integer type) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsCode = goodsCode;
        this.goodsCount = goodsCount;
        this.fileId = fileId;
        this.sponsor = sponsor;
        this.memo = memo;
        this.deleteFlag = deleteFlag;
        this.price = price;
        this.discount = discount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Article{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsCount=" + goodsCount +
                ", fileId='" + fileId + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", memo='" + memo + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", price=" + price +
                ", discount=" + discount +
                ", type=" + type +
                '}';
    }

    public Article() {
        super();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}