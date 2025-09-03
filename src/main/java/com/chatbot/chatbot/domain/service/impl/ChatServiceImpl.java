package com.chatbot.chatbot.domain.service.impl;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.chatbot.chatbot.domain.service.ChatService;

import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatClient ollamaClient;
    private final ChatClient geminiClient;

    public ChatServiceImpl(
            @Qualifier("ollamaClient") ChatClient ollamaClient,
            @Qualifier("geminiClient") ChatClient geminiClient) {
        this.ollamaClient = ollamaClient;
        this.geminiClient = geminiClient;
    }

    @Override
    public String getResponse(String provider, String message) {
        ChatClient client = provider.equalsIgnoreCase("gemini") ? geminiClient : ollamaClient;

        return client.prompt()
                .user(message)
                .call()
                .content();
    }
}
