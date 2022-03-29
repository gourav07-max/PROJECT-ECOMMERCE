package com.example.Postgresql.service;

import com.example.Postgresql.entity.UserHistoryEntity;
import com.example.Postgresql.repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserHistoryServiceImpl implements UserHistoryService{

    @Autowired
    UserHistoryRepository historyRepository;

    @Override
    public  List<UserHistoryEntity> showHistory(Integer userId){
        Iterable<UserHistoryEntity>list=historyRepository.findAll();
        List<UserHistoryEntity>responseEntity=new ArrayList<>();
        for(UserHistoryEntity historyEntity:list){
            if(userId==historyEntity.getUserId()){
                responseEntity.add(historyEntity);
            }
        }
        return responseEntity;
    }
}
