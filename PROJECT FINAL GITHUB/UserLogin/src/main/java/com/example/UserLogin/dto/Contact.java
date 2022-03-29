package com.example.UserLogin.dto;

public class Contact {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String name;

    public Contact(String name, String email, String country, String subject) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.subject = subject;
    }

    private String email;
    private String country;
    private String subject;

    public Contact(){}

}
