package com.example.Postgresql.service;

import com.example.Postgresql.dto.Merchant;

import java.util.List;

public interface MerchantService {


    boolean login(String email,String password);
    boolean signup(Merchant merchant);
    Integer byid(String email,String password);

    List<Merchant> get();


}
