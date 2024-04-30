package com.app.social.model.dto;

public class UpdatePostDto {
    private String postBody;
    private Long postID;

    public UpdatePostDto() {

    }

    public UpdatePostDto(String postBody, Long postID) {
        this.postBody = postBody;
        this.postID = postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }
}
