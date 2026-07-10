package com.study.user.service.controller;

import com.study.common.core.ApiResponse;
import com.study.common.core.ServiceNames;
import com.study.user.api.UserApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController implements UserApi {

    @Override
    @GetMapping("/health")
    public ApiResponse<Map<String, String>> health() {
        return ApiResponse.success(Map.of("service", ServiceNames.USER, "status", "UP"));
    }

    @Override
    @GetMapping("/me")
    public ApiResponse<Map<String, Object>> currentUser() {
        return ApiResponse.success(Map.of(
                "id", 1L,
                "username", "demo-user",
                "nickname", "Demo User"
        ));
    }
}
