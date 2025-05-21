package com.helpdeskhub.comments.mapper;

import com.helpdeskhub.comments.dto.CommentCreateDTO;
import com.helpdeskhub.comments.dto.CommentResponseDTO;
import com.helpdeskhub.comments.dto.CommentUpdateDTO;
import com.helpdeskhub.comments.model.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentMapper {
    
    public Comment toComment(CommentCreateDTO dto) {
        return Comment.builder()
                .content(dto.getContent())
                .ticketId(dto.getTicketId())
                .authorId(dto.getAuthorId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public CommentResponseDTO toCommentResponseDTO(Comment Comment) {
        return CommentResponseDTO.builder()
                .id(Comment.getId())
                .content(Comment.getContent())
                .ticketId(Comment.getTicketId())
                .authorId(Comment.getAuthorId())
                .createdAt(Comment.getCreatedAt())
                .updatedAt(Comment.getUpdatedAt())
                .build();
    }

    public void updateCommentFromDTO(Comment Comment, CommentUpdateDTO dto) {
        if (dto.getContent() != null) {
            Comment.setContent(dto.getContent());
        }
        Comment.setUpdatedAt(LocalDateTime.now());
    }
}
