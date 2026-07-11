package com.study.ai.api;

import com.study.ai.api.dto.ChatRequest;
import com.study.ai.api.dto.PlanGenerateRequest;
import com.study.ai.api.dto.SummarizeRequest;
import com.study.common.core.ApiResponse;

import java.util.Map;

public interface AiApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, String>> chat(ChatRequest request);

    ApiResponse<Map<String, Object>> summarize(SummarizeRequest request);

    ApiResponse<Map<String, Object>> generatePlan(PlanGenerateRequest request);
}
