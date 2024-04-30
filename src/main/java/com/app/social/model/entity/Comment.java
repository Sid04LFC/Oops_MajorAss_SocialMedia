package com.app.social.model.entity;

import com.app.social.model.dto.Commenter;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long commentID;
    private String commentBody;
    @ManyToOne(fetch = FetchType.EAGER)
    private User commenter;

    public Commenter getCommenter() {
        Commenter commenter = new Commenter();
        commenter.setName(this.commenter.getName());
        commenter.setEmail(this.commenter.getEmail());
        return commenter;
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

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }
}
