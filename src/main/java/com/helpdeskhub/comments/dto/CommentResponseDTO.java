package com.helpdeskhub.comments.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentResponseDTO {
    private Integer id;
    private String content;
    private Integer ticketId;
    private Integer authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
