package com.example.UserLogin.controller;


import com.example.UserLogin.dto.Contact;
import com.example.UserLogin.dto.User;
import com.example.UserLogin.response.Response;
import com.example.UserLogin.service.ContactService;
import com.example.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/signup")
@Valid
public class MyController {
    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;



    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path="/get" ,produces = "application/json")
    public List<User> userlogin1(){

        return userService.get();
    }


    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path="/userlogin" ,produces = "application/json")
    public Response<Boolean> userlogin2(@RequestParam String email,String password){

        Boolean isTrue = userService.login(email,password);
        if(isTrue){

            return new Response<>(true);

        }else {
            return new Response<>(6001 , "unable to login");
        }
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path="/usersignup" ,produces = "application/json")
    public Response<Boolean> usersignup(@RequestBody @Valid User user){


        Boolean isTrue = userService.signup(user);
        if(isTrue){
            return new Response<>(true);
        }else {
            return new Response<>(6001 , "unable to signup");
        }

    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path="/contact" ,produces = "application/json")
    public void contact(@RequestBody @Valid Contact contact){
        contactService.submit(contact);
    }


    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path="/byid" ,produces = "application/json")
    public Integer byid(@RequestParam @Valid String email,String password){
        return userService.byid(email,password);
    }
}
