package com.example.Postgresql.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ProductRating")
public class ProductRatingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productRatingId", nullable = false)
    private int productId;

    public ProductRatingEntity(int productId, int productRating) {
        this.productId = productId;
        this.productRating = productRating;
    }

    public ProductRatingEntity(){}
    private int productRating;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }
}
