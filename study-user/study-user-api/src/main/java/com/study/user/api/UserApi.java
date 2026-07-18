package com.study.user.api;

import com.study.user.api.dto.WxUserLoginRequest;

import java.util.Map;

public interface UserApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, Object>> currentUser();

    ApiResponse<Map<String, Object>> getUserById(Long id);

    ApiResponse<Map<String, Object>> getUserByWxOpenId(String openId);

    ApiResponse<Map<String, Object>> registerOrLoginByWx(WxUserLoginRequest request);
}
