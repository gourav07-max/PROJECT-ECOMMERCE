package com.example.Postgresql.repository;

import com.example.Postgresql.entity.MerchantProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantProductRepository extends CrudRepository<MerchantProductEntity,Integer> {
}
