package com.example.Product.Services;

import com.example.Product.Entity.ProductEntity;
import com.example.Product.dto.MerchantProduct;
import com.example.Product.dto.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    void adds(MerchantProduct product);

    void delete(Integer id);
    List<MerchantProduct> getAll();
    ProductEntity getProductById(Integer id);
    List<MerchantProduct> getByCategory(String category);


}
