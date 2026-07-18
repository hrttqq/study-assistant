package com.study.wx.service.service;

import org.springframework.stereotype.Service;

import com.study.wx.service.config.WxMiniProgramProperties;
import com.study.wx.service.domain.LoginSession;
import com.study.wx.service.domain.WxSession;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WxLoginSessionService {

    private final Map<String, LoginSession> sessions = new ConcurrentHashMap<>();
    private final WxMiniProgramProperties properties;

    public WxLoginSessionService(WxMiniProgramProperties properties) {
        this.properties = properties;
    }

    public LoginSession createSession(WxSession wxSession, Map<String, Object> user) {
        String token = UUID.randomUUID().toString().replace("-", "");
        LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(properties.getTokenTtlMinutes());
        LoginSession session = new LoginSession(token, expiresAt, wxSession, user);
        sessions.put(token, session);
        return session;
    }

    public LoginSession getValidSession(String token) {
        LoginSession session = sessions.get(token);
        if (session == null || session.expiresAt().isBefore(LocalDateTime.now())) {
            return null;
        }
        return session;
    }
}
