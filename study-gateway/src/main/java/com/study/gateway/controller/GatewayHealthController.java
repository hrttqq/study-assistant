package com.study.gateway.controller;

import com.study.common.core.ApiResponse;
import com.study.common.core.ServiceNames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GatewayHealthController {

    @GetMapping("/gateway/health")
    public ApiResponse<Map<String, String>> health() {
        return ApiResponse.success(Map.of("service", ServiceNames.GATEWAY, "status", "UP"));
    }
}
