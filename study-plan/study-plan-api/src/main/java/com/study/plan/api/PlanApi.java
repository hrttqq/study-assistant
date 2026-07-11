package com.study.plan.api;

import com.study.common.core.ApiResponse;
import com.study.plan.api.dto.CheckInRequest;
import com.study.plan.api.dto.ExamPlanCreateRequest;

import java.util.List;
import java.util.Map;

public interface PlanApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, Object>> createPlan(ExamPlanCreateRequest request);

    ApiResponse<List<Map<String, Object>>> listPlans();

    ApiResponse<List<Map<String, Object>>> listTasks(Long planId);

    ApiResponse<Map<String, Object>> checkIn(CheckInRequest request);
}
