package com.example.UserLogin.dto;

public class User {
    private String username;
    private String email;
    private Integer id;
    private String password;

    public User(String username, String email, Integer id, String password, String confirmpassword) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    private String confirmpassword;


    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public User(Integer id, String email, String password, String confirmpassword, String username){
        this.username = username;
        this.email = email;
        this.id = id;
        this.password = password;
        this.confirmpassword = confirmpassword;

    }

    public User(){}


}
