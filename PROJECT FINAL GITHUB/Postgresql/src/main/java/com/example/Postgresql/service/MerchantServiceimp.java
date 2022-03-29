package com.example.Postgresql.service;


import com.example.Postgresql.dto.Merchant;
import com.example.Postgresql.entity.MerchantEntity;
import com.example.Postgresql.entity.MerchantProductEntity;
import com.example.Postgresql.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantServiceimp implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;


    @Override
    public boolean login(String email, String password) {
        Iterable<MerchantEntity> merchantEntities=merchantRepository.findAll();
        for(MerchantEntity merchantEntity:merchantEntities){
            if (merchantEntity.getPassword().equals(password) && merchantEntity.getEmail().equals(email)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean signup(Merchant merchant) {

        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setName(merchant.getName());
        merchantEntity.setEmail(merchant.getEmail());
        merchantEntity.setPassword(merchant.getPassword());
        merchantEntity.setConfirmpassword(merchant.getConfirmpassword());

        List<MerchantEntity> merchantEntities = merchantRepository.findByEmail(merchant.getEmail());
        if (merchantEntities.size() == 0) {
            if (merchantEntity.getPassword().equals(merchantEntity.getConfirmpassword())) {
                merchantRepository.save(merchantEntity);
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer byid(String email, String password) {

        Iterable<MerchantEntity> merchantEntities = merchantRepository.findAll();
        for (MerchantEntity merchantEntity : merchantEntities) {

            if (merchantEntity.getPassword().equals(password)&& merchantEntity.getEmail().equals(email)) {
                Integer id=merchantEntity.getId();
                return id;


            }
        }
        return null;
    }

    @Override
    public List<Merchant> get() {
        Iterable<MerchantEntity> merchantEntities=merchantRepository.findAll();
        List<Merchant> userList=new ArrayList<>();
        for(MerchantEntity merchantEntity:merchantEntities){
            Merchant product=new Merchant(merchantEntity.getPassword(),merchantEntity.getName(),merchantEntity.getId(),merchantEntity.getConfirmpassword(),merchantEntity.getEmail());
            userList.add(product);
        }

        return userList;
    }
}
