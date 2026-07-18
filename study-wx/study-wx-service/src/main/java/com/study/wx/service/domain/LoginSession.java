package com.study.wx.service.domain;

import java.time.LocalDateTime;
import java.util.Map;

public record LoginSession(
        String accessToken,
        LocalDateTime expiresAt,
        WxSession wxSession,
        Map<String, Object> user
) {
}
