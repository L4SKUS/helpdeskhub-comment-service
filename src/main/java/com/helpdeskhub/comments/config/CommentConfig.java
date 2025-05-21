package com.helpdeskhub.comments.config;

import com.helpdeskhub.comments.model.Comment;
import com.helpdeskhub.comments.repository.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class CommentConfig {

    @Bean
    CommandLineRunner commandLineRunner(CommentRepository repository) {
        return args -> {
            Comment comment1 = Comment.builder()
                    .content("This is a test comment to see if this microservice work")
                    .ticketId(1)
                    .authorId(1)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Comment comment2 = Comment.builder()
                    .content("teeeeesssstttt reply")
                    .ticketId(1)
                    .authorId(3)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            repository.saveAll(List.of(comment1, comment2));
        };
    }
}
