package com.chatbot.chatbot.domain.dto;
import lombok.Data;

@Data
public class ChatRequest {
    @jakarta.validation.constraints.NotBlank(message = "Message cannot be empty")
    private String message;
}
