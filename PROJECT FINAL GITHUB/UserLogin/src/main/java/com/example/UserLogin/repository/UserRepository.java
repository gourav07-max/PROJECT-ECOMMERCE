package com.example.UserLogin.repository;

import com.example.UserLogin.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    List<UserEntity> findByEmail(String email);
}
