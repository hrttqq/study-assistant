package com.study.wx.api.dto;

public record WxOneClickLoginRequest(
        String code,
        String nickname,
        String avatarUrl
) {
}
