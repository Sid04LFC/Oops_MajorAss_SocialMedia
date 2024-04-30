package com.app.social.controller;

import com.app.social.model.dto.AddCommentDTO;
import com.app.social.model.dto.CreatePostDTO;
import com.app.social.model.dto.UpdateCommentDTO;
import com.app.social.model.dto.UpdatePostDto;
import com.app.social.model.entity.Post;
import com.app.social.service.SocialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    private final SocialService socialService;

    public SocialController(SocialService socialService) {
        this.socialService = socialService;
    }

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return socialService.findAllPosts();
    }

    @PostMapping("/post")
    public ResponseEntity<?> savePost(@RequestBody CreatePostDTO createPostDTO) {
        return socialService.createPost(createPostDTO);
    }

    @PatchMapping("/post")
    public ResponseEntity<?> updatePost(@RequestBody UpdatePostDto updatePostDto) {
        return socialService.updatePost(updatePostDto);
    }

    @GetMapping("/post")
    public ResponseEntity<?> getPostById(@RequestParam Long id) {
        return socialService.getPostById(id);
    }

    @DeleteMapping("/post")
    public ResponseEntity<?> deletePost(@RequestParam Long id) {
        return socialService.removePost(id);
    }

    @PostMapping("/comment")
    public ResponseEntity<?> doComment(@RequestBody AddCommentDTO addCommentDTO) {
        return socialService.createComment(addCommentDTO);
    }

    @GetMapping("/comments")
    public ResponseEntity<?> fetchAllComments() {
        return socialService.fetchAllComments();
    }

    @GetMapping("/comment")
    public ResponseEntity<?> findCommentByItsId(@RequestParam Long id) {
        return socialService.findCommentById(id);
    }


    @PatchMapping("/comment")
    public ResponseEntity<?> updateExistingComment(@RequestBody UpdateCommentDTO updateCommentDTO) {
        return socialService.updateExistingComment(updateCommentDTO);
    }

    @DeleteMapping("/comment")
    public ResponseEntity<?> deleteComment(@RequestParam Long id) {
        return socialService.deleteComment(id);
    }
}
