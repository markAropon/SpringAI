package com.chatbot.chatbot.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
public class AIConfig {

    @Bean
    @Qualifier("ollamaClient")
    public ChatClient ollamaClient(OllamaChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel).build();
    }

    @Bean
    @Qualifier("geminiClient")
    public ChatClient geminiClient(VertexAiGeminiChatModel geminiChatModel) {
        return ChatClient.builder(geminiChatModel).build();
    }
}
