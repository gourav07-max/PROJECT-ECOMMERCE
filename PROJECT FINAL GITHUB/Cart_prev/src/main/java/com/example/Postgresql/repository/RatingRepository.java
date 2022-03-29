package com.example.Postgresql.repository;

import com.example.Postgresql.entity.CartEntity;
import com.example.Postgresql.entity.ProductRatingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<ProductRatingEntity,Integer> {

}
