package com.app.social.model.dto;

public class AddCommentDTO {
    Long userID;
    Long postID;
    String commentBody;

    public AddCommentDTO() {
    }

    public AddCommentDTO(Long userID, Long postID, String commentBody) {
        this.userID = userID;
        this.postID = postID;
        this.commentBody = commentBody;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
