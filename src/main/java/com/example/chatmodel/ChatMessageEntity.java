package com.example.chatmodel;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
@Entity
@Table(name ="chat_message")
public class ChatMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;

    @Column(columnDefinition="TEXT")
    private String content;

    private LocalDateTime timestamp;

    public ChatMessageEntity() {}

    public ChatMessageEntity(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

