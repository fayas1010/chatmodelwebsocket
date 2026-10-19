package com.example.chatmodel;
import com.example.chat.entity.ChatMessageEntity;
import com.example.chat.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatHistoryController {

    @Autowired
    private ChatMessageRepository messageRepository;

    @GetMapping("/history")
    public List<ChatMessageEntity> getChatHistory() {
        return messageRepository.findTop50ByOrderByTimestampAsc();
    }
}