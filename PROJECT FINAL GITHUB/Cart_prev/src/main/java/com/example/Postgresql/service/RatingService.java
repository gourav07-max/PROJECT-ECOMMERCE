package com.example.Postgresql.service;

import com.example.Postgresql.entity.ProductRatingEntity;

import java.util.Optional;

public interface RatingService {
    Optional<ProductRatingEntity> getRating(int productId);
    void updateRating(int productId,int productRating);
}
