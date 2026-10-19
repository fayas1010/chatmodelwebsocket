package com.example.chatmodel;
import com.example.chat.entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {
    // Fetch last 50 messages ordered by time for chat history
    List<ChatMessageEntity> findTop50ByOrderByTimestampAsc();
}