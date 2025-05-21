package com.helpdeskhub.comments.dto;

import lombok.Data;

@Data
public class CommentCreateDTO {
    private String content;
    private Integer ticketId;
    private Integer authorId;
}