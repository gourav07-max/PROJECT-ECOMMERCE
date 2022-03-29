package com.example.Postgresql.service;

import com.example.Postgresql.dto.Cart;
import com.example.Postgresql.entity.CartEntity;

import java.util.List;

public interface CartService {
     void removeFromCart(Integer productId , Integer userId);
     void addToCart(Integer mid , Integer pid,Integer userId);
     void buyFromCart(Integer userId);
     List<CartEntity> getAllCartProducts(Integer userId);
     void removeAllCartProducts(Integer userId);
}
