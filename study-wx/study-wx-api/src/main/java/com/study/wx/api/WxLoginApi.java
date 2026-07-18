package com.study.wx.api;

import com.study.common.core.ApiResponse;
import com.study.wx.api.dto.WxLoginResponse;
import com.study.wx.api.dto.WxOneClickLoginRequest;
import com.study.wx.api.dto.WxSilentLoginRequest;

import java.util.Map;

public interface WxLoginApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<WxLoginResponse> oneClickLogin(WxOneClickLoginRequest request);

    ApiResponse<WxLoginResponse> silentLogin(WxSilentLoginRequest request);
}
