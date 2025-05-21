package com.helpdeskhub.comments.service;

import com.helpdeskhub.comments.dto.CommentResponseDTO;
import com.helpdeskhub.comments.mapper.CommentMapper;
import com.helpdeskhub.comments.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public List<CommentResponseDTO> getAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toCommentResponseDTO)
                .collect(Collectors.toList());
    }
}
