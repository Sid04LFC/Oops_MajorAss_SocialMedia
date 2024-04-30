package com.app.social.service;

import com.app.social.dao.CommentRepository;
import com.app.social.dao.PostRepository;
import com.app.social.dao.UserRepository;
import com.app.social.model.dto.*;
import com.app.social.model.entity.Comment;
import com.app.social.model.entity.Post;
import com.app.social.model.entity.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SocialService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public SocialService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<?> getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            return ResponseEntity.ok(new ErrResponse("Post does not exist"));
        }
        PostResponseDTO postResponseDto = new PostResponseDTO();
        postResponseDto.setPostBody(post.get().getPostBody());
        postResponseDto.setPostID(post.get().getPostID());
        postResponseDto.setDate(post.get().getDate());
        for (Comment comment : post.get().getComments()) {
            CommentResponseDTO commentResponseDto = new CommentResponseDTO();
            commentResponseDto.setCommentBody(comment.getCommentBody());
            commentResponseDto.setCommentID(comment.getCommentID());
            commentResponseDto.setCommentCreator(comment.getCommenter());
        }
        return ResponseEntity.ok(postResponseDto);
    }

    public ResponseEntity<?> updatePost(UpdatePostDto updatePostDto) {
        Optional<Post> post = postRepository.findById(updatePostDto.getPostID());
        if (post.isEmpty()) {
            return ResponseEntity.ok(new ErrResponse("Post does not exist"));
        }
        post.get().setPostBody(updatePostDto.getPostBody());
        postRepository.save(post.get());
        return ResponseEntity.ok("Post edited successfully");
    }


    public ResponseEntity<?> fetchAllComments() {
        return new ResponseEntity<>(commentRepository.findAll(), HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<?> updateExistingComment(UpdateCommentDTO updateCommentDTO) {
        Optional<Comment> comment = commentRepository.findById(updateCommentDTO.getCommentID());
        if (comment.isEmpty()) {
            return ResponseEntity.ok(new ErrResponse("Comment does not exist"));
        }
        comment.get().setCommentBody(updateCommentDTO.getCommentBody());
        commentRepository.save(comment.get());
        return ResponseEntity.ok("Comment edited successfully");
    }


    public ResponseEntity<?> deleteComment(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isEmpty()) {
            return ResponseEntity.ok(new ErrResponse("Comment does not exist"));
        } else {
            commentRepository.deleteById(id);
            return ResponseEntity.ok("Comment deleted successfully");
        }
    }

    public ResponseEntity<?> findCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isEmpty()) {
            return ResponseEntity.ok(new ErrResponse("Comment does not exist"));
        } else {
            CommentResponseDTO commentResponseDto = new CommentResponseDTO();
            commentResponseDto.setCommentID(comment.get().getCommentID());
            commentResponseDto.setCommentBody(comment.get().getCommentBody());
            commentResponseDto.setCommentCreator(comment.get().getCommenter());
            return ResponseEntity.ok(commentResponseDto);
        }
    }

    public List<Post> findAllPosts() {
        return postRepository.findAllByOrderByDateDesc();
    }

    public ResponseEntity<?> createPost(CreatePostDTO createPostDTO) {
        Optional<User> user = userRepository.findById(createPostDTO.getUserID());
        if (user.isEmpty()) {
            return ResponseEntity.ok(new ErrResponse("User does not exist"));
        }
        Post post = new Post();
        post.setPostBody(createPostDTO.getPostBody());
        post.setDate(LocalDate.now());
        postRepository.save(post);

        if (user.get().getPosts() == null) {
            user.get().setPosts(new ArrayList<>());
        }
        user.get().getPosts().add(post);
        userRepository.save(user.get());
        return ResponseEntity.ok("Post created successfully");
    }

    public ResponseEntity<?> removePost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            return ResponseEntity.ok(new ErrResponse("Post does not exist"));
        }
        postRepository.delete(post.get());
        return ResponseEntity.ok("Post deleted");
    }

    public ResponseEntity<?> createComment(AddCommentDTO addCommentDTO) {
        Optional<User> user = userRepository.findById(addCommentDTO.getUserID());
        if (user.isEmpty()) {
            return ResponseEntity.ok(new ErrResponse("User does not exist"));
        } else {
            Optional<Post> post = postRepository.findById(addCommentDTO.getPostID());
            if (post.isEmpty()) {
                return ResponseEntity.ok(new ErrResponse("Post does not exist"));
            } else {
                Comment comment = new Comment();
                comment.setCommentBody(addCommentDTO.getCommentBody());
                comment.setCommenter(user.get());
                Comment savedComment = commentRepository.save(comment);
                post.get().getComments().add(savedComment);
                postRepository.save(post.get());
                return ResponseEntity.ok("Comment created successfully");
            }
        }
    }

}
