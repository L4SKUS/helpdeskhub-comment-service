package com.helpdeskhub.comments.controller;

import com.helpdeskhub.comments.dto.CommentResponseDTO;
import com.helpdeskhub.comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }
}
