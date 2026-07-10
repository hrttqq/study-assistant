package com.study.auth.controller;

import com.study.common.core.ApiResponse;
import com.study.common.core.ServiceNames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/health")
    public ApiResponse<Map<String, String>> health() {
        return ApiResponse.success(Map.of("service", ServiceNames.AUTH, "status", "UP"));
    }

    @PostMapping("/login")
    public ApiResponse<Map<String, String>> login(@RequestBody LoginRequest request) {
        return ApiResponse.success(Map.of(
                "username", request.username(),
                "token", "mock-token"
        ));
    }

    public record LoginRequest(String username, String password) {
    }
}
