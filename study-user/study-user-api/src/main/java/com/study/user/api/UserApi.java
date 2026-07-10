package com.study.user.api;

import com.study.common.core.ApiResponse;

import java.util.Map;

public interface UserApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, Object>> currentUser();
}
