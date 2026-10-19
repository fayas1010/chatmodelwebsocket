package com.example.chatmodel;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerRegistry;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerRegistry {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Broadcast prefix: clients subscribe to /topic/public to receive messages
        config.enableSimpleBroker("/topic");

        // Send prefix: clients send messages to /app/chat.sendMessage
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // The URL where WebSocket handshakes occur
        registry.addEndpoint("/ws-chat")
                .setAllowedOriginPatterns("*"); // Allow cross-origin requests
    }
}