package com.example.Postgresql.dto;

import java.io.Serializable;

public class Merchant implements Serializable {


    private String password;
    private String name;
    private Integer id;
    private String confirmpassword;
    private String email;

    public Merchant(String password, String name, Integer id, String confirmpassword, String email) {
        this.password = password;
        this.name = name;
        this.id = id;
        this.confirmpassword = confirmpassword;
        this.email = email;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Merchant(){}



}
