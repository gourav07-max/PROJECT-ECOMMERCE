package com.example.UserLogin.repository;


import com.example.UserLogin.entity.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity,Integer> {




}
