package com.study.notification.api.dto;

import java.time.LocalDateTime;

public record ReminderCreateRequest(String title, String content, LocalDateTime remindAt) {
}
