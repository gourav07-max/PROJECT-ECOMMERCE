package com.example.UserLogin.service;

import com.example.UserLogin.dto.User;

import java.util.List;

public interface UserService {

    boolean login(String email,String password);
    boolean signup(User user);
    Integer byid(String email,String password);

    List<User> get();
}
