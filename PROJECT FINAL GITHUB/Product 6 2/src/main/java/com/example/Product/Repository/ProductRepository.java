package com.example.Product.Repository;

import com.example.Product.Entity.ProductEntity;
import com.example.Product.dto.MerchantProduct;
import com.example.Product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, Integer> {

List<MerchantProduct> findBycategory(String category);
 ProductEntity findByproductid(Integer id);

 void deleteByproductid(Integer id);
 List<ProductEntity> findByname(String name);

}
