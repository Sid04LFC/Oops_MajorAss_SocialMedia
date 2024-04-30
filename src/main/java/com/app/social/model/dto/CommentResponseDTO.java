package com.app.social.model.dto;

public class CommentResponseDTO {
    private Long commentID;
    private String commentBody;
    private Commenter commentCreator;

    public CommentResponseDTO() {

    }

    public CommentResponseDTO(Long commentID, String commentBody, Commenter commentCreator) {
        this.commentID = commentID;
        this.commentBody = commentBody;
        this.commentCreator = commentCreator;
    }

    public CommentResponseDTO(Long commentID, String commentBody) {
        this.commentID = commentID;
        this.commentBody = commentBody;
    }

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Commenter getCommentCreator() {
        return commentCreator;
    }

    public void setCommentCreator(Commenter commentCreator) {
        this.commentCreator = commentCreator;
    }
}
