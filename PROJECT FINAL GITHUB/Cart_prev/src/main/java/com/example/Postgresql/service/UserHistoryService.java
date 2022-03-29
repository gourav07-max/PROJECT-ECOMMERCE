package com.example.Postgresql.service;

import com.example.Postgresql.entity.UserHistoryEntity;

import java.util.List;

public interface UserHistoryService {
    List<UserHistoryEntity> showHistory(Integer userId);
}
