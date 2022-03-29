package com.example.Product.dto;


public class MerchantProduct {
    private Integer merchantid;
    private Integer productid;
    private Integer price;
    private Integer stock;
    private String name;
    private String description;
    private String category;
    private String merchantname;
    private String imgurl;
    private Integer algovalue;


    public MerchantProduct(){}

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public MerchantProduct(Integer merchantid, Integer productid, Integer price, Integer stock, String name, String description, String category, String merchantname, String imgurl,Integer algovalue) {
        this.merchantid = merchantid;
        this.productid = productid;
        this.price = price;
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.category = category;
        this.merchantname = merchantname;
        this.imgurl = imgurl;
        this.algovalue=algovalue;
    }





    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getAlgovalue() {
        return algovalue;
    }

    public void setAlgovalue(Integer algovalue) {
        this.algovalue = algovalue;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
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



}



