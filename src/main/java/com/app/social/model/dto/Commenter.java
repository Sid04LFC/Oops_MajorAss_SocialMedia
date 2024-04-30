package com.app.social.model.dto;

public class Commenter {
    private String name;
    private String email;

    public Commenter() {
    }

    public Commenter(String name, String email) {
        this.name = name;
        this.email = email;
    }

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
}
