package com.helpdeskhub.comments.service;

import com.helpdeskhub.comments.dto.CommentCreateDTO;
import com.helpdeskhub.comments.dto.CommentResponseDTO;
import com.helpdeskhub.comments.dto.CommentUpdateDTO;
import com.helpdeskhub.comments.mapper.CommentMapper;
import com.helpdeskhub.comments.model.Comment;
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

    public CommentResponseDTO createComment(CommentCreateDTO dto) {
        Comment newComment = commentMapper.toComment(dto);
        Comment savedComment = commentRepository.save(newComment);
        return commentMapper.toCommentResponseDTO(savedComment);
    }

    public List<CommentResponseDTO> getAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toCommentResponseDTO)
                .collect(Collectors.toList());
    }

    public List<CommentResponseDTO> getCommentsByTicketId(Integer ticketId) {
        return commentRepository.findAllByTicketId(ticketId)
                .stream()
                .map(commentMapper::toCommentResponseDTO)
                .collect(Collectors.toList());
    }

    public void deleteComment(Integer commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new IllegalStateException("Comment not found with id: " + commentId);
        }
        commentRepository.deleteById(commentId);
    }

    public CommentResponseDTO updateComment(Integer commentId, CommentUpdateDTO dto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalStateException("Comment not found with id: " + commentId));
        commentMapper.updateCommentFromDTO(comment, dto);
        Comment updatedComment = commentRepository.save(comment);
        return commentMapper.toCommentResponseDTO(updatedComment);
    }
}
