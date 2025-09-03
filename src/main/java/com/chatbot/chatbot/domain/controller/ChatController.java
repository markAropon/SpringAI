package com.chatbot.chatbot.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chatbot.chatbot.domain.dto.ChatRequest;
import com.chatbot.chatbot.domain.dto.ChatResponse;
import com.chatbot.chatbot.domain.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @PostMapping
    public ResponseEntity<ChatResponse> chat(
            @RequestParam(defaultValue = "ollama") String provider,
            @RequestBody ChatRequest request) {
        String response = chatService.getResponse(provider, request.getMessage());

        return ResponseEntity.ok(new ChatResponse(provider, response));
    }
}
