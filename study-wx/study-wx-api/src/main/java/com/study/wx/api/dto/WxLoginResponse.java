package com.study.wx.api.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record WxLoginResponse(
        String accessToken,
        LocalDateTime expiresAt,
        Boolean registered,
        Boolean silent,
        Map<String, Object> user
) {
}
