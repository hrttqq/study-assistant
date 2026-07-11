package com.study.plan.api.dto;

public record CheckInRequest(Long taskId, Boolean completed, String note) {
}
