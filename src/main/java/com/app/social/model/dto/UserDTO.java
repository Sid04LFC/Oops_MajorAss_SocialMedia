package com.app.social.model.dto;

public class UserDTO {
    private Long userID;
    private String name;
    private String email;

    public UserDTO() {

    }

    public UserDTO(Long userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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
