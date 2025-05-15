package com.coditas.GenAI_Java.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.coditas.GenAI_Java.PromptConstants.TIC_TAC_TOE_PROMPT;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private ChatClient chatClient;
    private ObjectMapper objectMapper;

    public AIController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
        this.chatClient.prompt(TIC_TAC_TOE_PROMPT);
        this.objectMapper = new ObjectMapper();
    }

    @PostMapping("/openai/nextMove")
    public ResponseEntity<Map<String, Object>> nextMoveOpenAI(@RequestBody Map<String, Object> requestBody) {
        System.out.println("Request: " + requestBody);
        try {
            String aiResponse = chatClient.prompt(TIC_TAC_TOE_PROMPT + requestBody.toString()).call().content();
            Map<String, Object> parsedResponse = objectMapper.readValue(aiResponse, Map.class);
            System.out.println("Response: " + aiResponse);
            return ResponseEntity.ok(parsedResponse);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to parse AI response: " + e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
