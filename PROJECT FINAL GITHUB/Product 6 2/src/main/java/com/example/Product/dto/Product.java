package com.example.Product.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



public class Product {



    private Integer productPojoId;

    @NotBlank(message = "should not be blank")
    private String name;


    @NotBlank(message = "should not be blank")
    private String description;


    @NotBlank(message = "should not be blank")
    private String imgurl;

    @NotBlank(message = "should not be blank")
    private String catogoryName;

    @NotBlank(message = "should not be blank")
    private String merchantname;


    @NotBlank(message = "should not be blank")
    private Integer merchantid;

    @NotNull(message = "should not be null")
    private Integer rating;


    @NotNull(message = "should not be null")
    private Integer price;



    public Product(){}


    public Product(int productPojoId, @NotBlank(message = "should not be blank") String name, @NotBlank(message = "should not be blank") String description, @NotBlank(message = "should not be blank") String imgurl, @NotBlank(message = "should not be blank")
     Integer merchantid, @NotBlank(message = "should not be blank") String catogoryName,@NotBlank(message = "should not be blank") String merchantname ,@NotNull(message = "should not be null") Integer rating, @NotNull(message = "should not be null") Integer price) {

        this.productPojoId = productPojoId;
        this.name = name;
        this.description = description;
        this.imgurl = imgurl;
        this.merchantid=merchantid;
        this.merchantname = merchantname;
        this.catogoryName=catogoryName;
        this.rating = rating;
        this.price = price;
    }

    public Integer getProductPojoId() {
        return productPojoId;
    }

    public void setProductPojoId(Integer productPojoId) {
        this.productPojoId = productPojoId;
    }



    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }




    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    public String getCatogoryName() {
        return catogoryName;
    }

    public void setCatogoryName(String catogoryName) {
        this.catogoryName = catogoryName;
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

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
