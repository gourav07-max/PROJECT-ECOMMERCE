package com.example.Postgresql.dto;

import java.io.Serializable;

public class MerchantProduct implements Serializable {
    private Integer merchantid;
    private Integer productid;
    private Integer price;
    private Integer stock;
    private Integer soldProducts;
    private String name;
    private String merchantname;
    private String description;
    private String imgurl;
    private String category;

    public MerchantProduct(Integer merchantid, Integer productid, Integer price, Integer stock, Integer soldProducts, String name, String merchantname, String description, String imgurl, String category, Integer rating, Integer algovalue) {
        this.merchantid = merchantid;
        this.productid = productid;
        this.price = price;
        this.stock = stock;
        this.soldProducts = soldProducts;
        this.name = name;
        this.merchantname = merchantname;
        this.description = description;
        this.imgurl = imgurl;
        this.category = category;
        this.rating = rating;
        this.algovalue = algovalue;
    }

    private Integer rating;
    private Integer algovalue;

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Integer soldProducts) {
        this.soldProducts = soldProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getAlgovalue() {
        return algovalue;
    }

    public void setAlgovalue(Integer algovalue) {
        this.algovalue = algovalue;
    }








    public MerchantProduct(){}











}
