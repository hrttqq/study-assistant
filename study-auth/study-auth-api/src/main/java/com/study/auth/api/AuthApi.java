package com.study.auth.api;

import com.study.auth.api.dto.LoginRequest;
import com.study.auth.api.dto.RegisterRequest;

import java.util.Map;

public interface AuthApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, Object>> register(RegisterRequest request);

    ApiResponse<Map<String, String>> login(LoginRequest request);
}
