package com.app.social.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostResponseDTO {
    private Long postID;
    private String postBody;
    private LocalDate date;
    private List<CommentResponseDTO> comments = new ArrayList<>();

    public PostResponseDTO() {
    }

    public PostResponseDTO(Long postID, String postBody, LocalDate date) {
        this.postID = postID;
        this.postBody = postBody;
        this.date = date;
    }

    public PostResponseDTO(Long postID, String postBody, LocalDate date, List<CommentResponseDTO> comments) {
        this.postID = postID;
        this.postBody = postBody;
        this.date = date;
        this.comments = comments;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<CommentResponseDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponseDTO> comments) {
        this.comments = comments;
    }
}
