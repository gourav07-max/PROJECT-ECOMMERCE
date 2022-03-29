package com.example.UserLogin.service;


import com.example.UserLogin.dto.Contact;
import com.example.UserLogin.entity.ContactEntity;
import com.example.UserLogin.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceimp implements ContactService{

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void submit(Contact contact) {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setCountry(contact.getCountry());
        contactEntity.setEmail(contact.getEmail());
        contactEntity.setSubject(contact.getSubject());
        contactEntity.setName(contact.getName());
        contactRepository.save(contactEntity);
    }
}
