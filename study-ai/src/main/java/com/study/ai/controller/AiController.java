package com.study.ai.controller;

import com.study.common.core.ApiResponse;
import com.study.common.core.ServiceNames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AiController {

    @GetMapping("/health")
    public ApiResponse<Map<String, String>> health() {
        return ApiResponse.success(Map.of("service", ServiceNames.AI, "status", "UP"));
    }

    @PostMapping("/chat")
    public ApiResponse<Map<String, String>> chat(@RequestBody ChatRequest request) {
        return ApiResponse.success(Map.of(
                "question", request.message(),
                "answer", "AI service is ready."
        ));
    }

    public record ChatRequest(String message) {
    }
}
