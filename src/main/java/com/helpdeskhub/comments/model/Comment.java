package com.helpdeskhub.comments.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(
            name = "ticket_seq",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Integer ticketId;

    @Column(nullable = false)
    private Integer authorId;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}