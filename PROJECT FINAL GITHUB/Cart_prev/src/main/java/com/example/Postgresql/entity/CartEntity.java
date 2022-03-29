package com.example.Postgresql.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cart")
public class CartEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartId", nullable = false)
    private Integer cartId;
    private Integer userId;
    private Integer productId;
    private Integer quantity;
    private Integer merchantId;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public CartEntity(Integer userId, Integer productId, Integer quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartEntity(Integer merchantId, Integer productId, Integer userId, Integer quantity ) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.merchantId = merchantId;
    }

    public  CartEntity(){}



}