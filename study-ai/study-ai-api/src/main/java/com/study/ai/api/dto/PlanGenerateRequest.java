package com.study.ai.api.dto;

import java.time.LocalDate;

public record PlanGenerateRequest(
        String examName,
        LocalDate examDate,
        Integer dailyStudyMinutes,
        Integer materialCount
) {
}
