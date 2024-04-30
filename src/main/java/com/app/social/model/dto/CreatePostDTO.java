package com.app.social.model.dto;

public class CreatePostDTO {
    private String postBody;
    private Long userID;

    public CreatePostDTO() {
    }

    public CreatePostDTO(String postBody, Long userID) {
        this.postBody = postBody;
        this.userID = userID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
