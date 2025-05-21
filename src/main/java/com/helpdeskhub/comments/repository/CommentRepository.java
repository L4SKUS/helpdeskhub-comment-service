package com.helpdeskhub.comments.repository;

import com.helpdeskhub.comments.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
