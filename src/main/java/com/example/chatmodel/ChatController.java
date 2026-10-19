package com.example.chatmodel;
import com.example.chat.dto.ChatMessageRequest;
import com.example.chat.entity.ChatMessageEntity;
import com.example.chat.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageRepository messageRepository;

    // Triggered when client sends to: /app/chat.sendMessage
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public") // Automatically broadcasts return value to everyone on /topic/public
    public ChatMessageEntity sendMessage(ChatMessageRequest request) {
        // 1. Save incoming message into MySQL
        ChatMessageEntity entity = new ChatMessageEntity(request.getSender(), request.getContent());
        ChatMessageEntity savedMessage = messageRepository.save(entity);

        // 2. Return saved entity (broadcasts ID, sender, content, and timestamp to subscribers)
        return savedMessage;
    }
}