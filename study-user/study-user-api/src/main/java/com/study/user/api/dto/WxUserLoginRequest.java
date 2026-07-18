package com.study.user.api.dto;

public record WxUserLoginRequest(String openId, String unionId, String nickname, String avatarUrl) {
}
