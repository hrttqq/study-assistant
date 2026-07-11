package com.study.notification.api;

import com.study.common.core.ApiResponse;
import com.study.notification.api.dto.ReminderCreateRequest;

import java.util.List;
import java.util.Map;

public interface NotificationApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, Object>> createReminder(ReminderCreateRequest request);

    ApiResponse<List<Map<String, Object>>> listReminders();
}
