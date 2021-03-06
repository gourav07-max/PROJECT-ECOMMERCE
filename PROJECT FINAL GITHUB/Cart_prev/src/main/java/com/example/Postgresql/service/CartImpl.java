package com.example.Postgresql.service;

import com.example.Postgresql.Feign.MerchantInterface;
import com.example.Postgresql.dto.Cart;
import com.example.Postgresql.entity.CartEntity;
import com.example.Postgresql.entity.UserHistoryEntity;
import com.example.Postgresql.repository.CartRepository;
import com.example.Postgresql.repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CartImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserHistoryRepository historyRepository;

    @Autowired
    MerchantInterface merchantInterface;

    @Override
    public void addToCart(Integer mid,Integer pid,Integer userId) {

        boolean status =merchantInterface.checkStock(mid,pid);
//        System.out.println(status);
        if(status) {
            Iterable<CartEntity> cartEntityList = cartRepository.findAll();
            boolean flag=false;
            for (CartEntity c : cartEntityList) {
//                System.out.println(c.getUserId());
                if (c.getUserId() == userId && c.getProductId() == pid) {

                    // throw exception if the value is already zero
                    int temp=c.getQuantity();
//                    System.out.println(temp);
                    c.setQuantity(temp+1);
//                    System.out.println(c.getQuantity());
                    cartRepository.save(c);
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                cartRepository.save(new CartEntity(mid,pid,userId,1));
            }
        }
    }

    @Override
    public void removeFromCart(Integer productId,Integer userId) {

        Iterable<CartEntity> cartEntityList=cartRepository.findAll();
        for(CartEntity c : cartEntityList){
            if(c.getUserId()==userId&&c.getProductId()==productId){

                if(c.getQuantity()-1>=0) {
                    c.setQuantity(c.getQuantity() - 1);
                    cartRepository.save(c);
                }
                    break;

            }
        }
        //custom exception will be thrown

    }

    @Override
    public void buyFromCart(Integer userId){
        Iterable<CartEntity> cartEntityList=cartRepository.findAll();
//        System.out.println("function");
        for(CartEntity c : cartEntityList){
            if(c.getUserId()==userId){
                // updateStock(mid,uid,count) using feign
//                System.out.println("buying");
                merchantInterface.stockUpdate(c.getMerchantId(),c.getProductId(),c.getQuantity());

                // add bought history in the record
                historyRepository.save(new UserHistoryEntity(c.getUserId(),c.getProductId(),c.getMerchantId(),c.getQuantity()));
            }
        }

        //update the default merchant in product using algorithm work later
        //-----

        //delete all products from cart
        Iterable<CartEntity> cartEntityList1=cartRepository.findAll();
        for(CartEntity c : cartEntityList1){
            if(c.getUserId()==userId){
                cartRepository.deleteById(c.getCartId());
            }
        }
//

    }

    @Override
    public List<CartEntity> getAllCartProducts(Integer userId){
        Iterable<CartEntity> cartEntityList=cartRepository.findAll();
        List<CartEntity> responseList=new ArrayList<>();
        for(CartEntity c : cartEntityList){
            if(c.getUserId()==userId){
                responseList.add(c);
            }
        }
        return responseList;
    }
    @Override
    public void removeAllCartProducts(Integer userId){
        Iterable<CartEntity> cartEntityList1=cartRepository.findAll();
        for(CartEntity c : cartEntityList1){
            if(c.getUserId()==userId){
                cartRepository.deleteById(c.getCartId());
            }
        }
    }
}
