package com.example.Postgresql.entity;


import javax.persistence.*;

@Entity
@Table(name="merchantproduct")
public class MerchantProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @ManyToOne
    //Adding the name
    @JoinColumn(name = "merchantid", referencedColumnName = "id")
    MerchantEntity merchantEntity;


    private Integer productid;
    private Integer price;
    private Integer stock;
    private Integer soldproducts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String merchantname;
    private String description;
    private String imgurl;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;
    private Integer rating;
    private Integer algovalue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSoldproducts() {
        return soldproducts;
    }

    public void setSoldproducts(Integer soldproducts) {
        this.soldproducts = soldproducts;
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









    public MerchantEntity getMerchantEntity() {
        return merchantEntity;
    }

    public Integer setMerchantEntity(MerchantEntity merchantEntity) {
        this.merchantEntity = merchantEntity;
        return null;
    }



    public MerchantProductEntity(){}







}
