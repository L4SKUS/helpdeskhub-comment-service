package com.helpdeskhub.comments.controller;

import com.helpdeskhub.comments.dto.CommentCreateDTO;
import com.helpdeskhub.comments.dto.CommentResponseDTO;
import com.helpdeskhub.comments.dto.CommentUpdateDTO;
import com.helpdeskhub.comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDTO> createComment(@RequestBody CommentCreateDTO dto) {
        CommentResponseDTO createdComment = commentService.createComment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<CommentResponseDTO>> getCommentsByTicketId(@PathVariable Integer ticketId) {
        List<CommentResponseDTO> comments = commentService.getCommentsByTicketId(ticketId);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDTO> updateComment(
            @PathVariable Integer commentId,
            @RequestBody CommentUpdateDTO dto) {
        CommentResponseDTO updatedComment = commentService.updateComment(commentId, dto);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
    }
}
