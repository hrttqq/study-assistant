package com.study.auth.api;

import com.study.auth.api.dto.LoginRequest;
import com.study.common.core.ApiResponse;

import java.util.Map;

public interface AuthApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, String>> login(LoginRequest request);
}
