package com.example.Postgresql.service;

import com.example.Postgresql.entity.ProductRatingEntity;
import com.example.Postgresql.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    RatingRepository ratingRepository;

    public Optional<ProductRatingEntity> getRating(int productId){
        return ratingRepository.findById(productId);
    }
    public void updateRating(int productId,int productRating){
        Iterable<ProductRatingEntity> value=ratingRepository.findAll();
        boolean flag=false;
        for(ProductRatingEntity p:value){
            if(p.getProductId()==productId){
                flag=true;
                p.setProductRating(productRating);
                ratingRepository.save(p);
            }
        }
        if(flag==true){
            ratingRepository.save(new ProductRatingEntity(productId,productRating));
        }

    }
}
