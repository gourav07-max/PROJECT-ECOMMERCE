package com.example.Postgresql.Restcontroller;

import com.example.Postgresql.dto.Merchant;
import com.example.Postgresql.response.Response;
import com.example.Postgresql.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/merchants")
@Valid
public class MerchantController {
    @Autowired
    MerchantService merchantService;




    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path="/login" ,produces = "application/json")
    public Response<Boolean> userlogin2(@RequestParam String email, String password){

        Boolean isTrue = merchantService.login(email,password);
        if(isTrue){

            return new Response<>(true);

        }else {
            return new Response<>(6001 , "unable to login");
        }
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path="/signup" ,produces = "application/json")
    public Response<Boolean> usersignup(@RequestBody @Valid Merchant merchant){


        Boolean isTrue = merchantService.signup(merchant);
        if(isTrue){
            return new Response<>(true);
        }else {
            return new Response<>(6001 , "unable to signup");
        }

    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path="/byid" ,produces = "application/json")
    public Integer byid(@RequestParam @Valid String email,String password){
        return merchantService.byid(email,password);
    }
}
