package com.example.UserLogin.service;

import com.example.UserLogin.dto.User;
import com.example.UserLogin.entity.UserEntity;
import com.example.UserLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceimp implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean login(String email, String password) {

//        List<UserEntity> userEntities = userRepository.findByEmail(email);
//        if (userEntities.size() != 0) {
//            if (userEntities.get(4).getPassword().equals(password)) {
//                return true;
//            }
//        }
        Iterable<UserEntity> userEntities=userRepository.findAll();
        for(UserEntity userEntity:userEntities){
            if (userEntity.getPassword().equals(password) && userEntity.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean signup(User user) {


        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setConfirmpassword(user.getConfirmpassword());

        List<UserEntity> userEntities = userRepository.findByEmail(user.getEmail());
        List<UserEntity> userEntities1 = userRepository.findByEmail(user.getUsername());
        if (userEntities.size() == 0) {
            if (userEntity.getPassword().equals(userEntity.getConfirmpassword())) {
                userRepository.save(userEntity);
                return true;
            }
        }
        return false;


    }

    @Override
    public Integer byid(String email, String password) {
        Iterable<UserEntity> userEntities = userRepository.findAll();
        for (UserEntity userEntity : userEntities) {

            if (userEntity.getPassword().equals(password)&& userEntity.getEmail().equals(email)) {
                Integer id=userEntity.getId();
                return id;


            }
        }
        return null;
    }



    @Override
    public List<User> get() {
        Iterable<UserEntity> userEntities=userRepository.findAll();
        List<User> userList=new ArrayList<>();
        for(UserEntity userEntity:userEntities){
                User product=new User(userEntity.getId(),userEntity.getEmail(),userEntity.getPassword(),userEntity.getConfirmpassword(),userEntity.getUsername());
                userList.add(product);
        }

        return userList;
    }
}
