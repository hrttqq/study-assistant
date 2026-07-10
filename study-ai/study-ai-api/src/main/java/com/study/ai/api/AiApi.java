package com.study.ai.api;

import com.study.ai.api.dto.ChatRequest;
import com.study.common.core.ApiResponse;

import java.util.Map;

public interface AiApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, String>> chat(ChatRequest request);
}
