package com.example.Postgresql.service;

import com.example.Postgresql.dto.MerchantProduct;

import java.util.List;

public interface MerchantProductService {

    void add(MerchantProduct merchant);
    void update(Integer stock,Integer mId);
    void delete(Integer id);
    List<Integer> deleteproduct();
    boolean checkStock(Integer mid,Integer pid);
    void stockUpdate(Integer mid,Integer pid,Integer quantity);

}
