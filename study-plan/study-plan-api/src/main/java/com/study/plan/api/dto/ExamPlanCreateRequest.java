package com.study.plan.api.dto;

import java.time.LocalDate;

public record ExamPlanCreateRequest(
        String examName,
        LocalDate examDate,
        Integer dailyStudyMinutes,
        String level
) {
}
