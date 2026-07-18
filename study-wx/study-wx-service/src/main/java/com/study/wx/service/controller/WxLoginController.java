package com.study.wx.service.controller;

import com.study.common.core.ApiResponse;
import com.study.common.core.ServiceNames;
import com.study.wx.api.WxLoginApi;
import com.study.wx.api.dto.WxLoginResponse;
import com.study.wx.api.dto.WxOneClickLoginRequest;
import com.study.wx.api.dto.WxSilentLoginRequest;
import com.study.wx.service.client.UserServiceClient;
import com.study.wx.service.client.WxMiniProgramClient;
import com.study.wx.service.domain.LoginSession;
import com.study.wx.service.domain.WxSession;
import com.study.wx.service.service.WxLoginSessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxLoginController implements WxLoginApi {

    private final WxMiniProgramClient wxMiniProgramClient;
    private final UserServiceClient userServiceClient;
    private final WxLoginSessionService loginSessionService;

    public WxLoginController(
            WxMiniProgramClient wxMiniProgramClient,
            UserServiceClient userServiceClient,
            WxLoginSessionService loginSessionService
    ) {
        this.wxMiniProgramClient = wxMiniProgramClient;
        this.userServiceClient = userServiceClient;
        this.loginSessionService = loginSessionService;
    }

    @Override
    @GetMapping("/health")
    public ApiResponse<Map<String, String>> health() {
        return ApiResponse.success(Map.of("service", ServiceNames.WX, "status", "UP"));
    }

    @Override
    @PostMapping("/login")
    public ApiResponse<WxLoginResponse> oneClickLogin(@RequestBody WxOneClickLoginRequest request) {
        if (request.code() == null || request.code().isBlank()) {
            return ApiResponse.fail(400, "code is required");
        }

        WxSession wxSession = wxMiniProgramClient.code2Session(request.code());
        ApiResponse<Map<String, Object>> userResponse = userServiceClient.registerOrLogin(
                wxSession.openId(),
                wxSession.unionId(),
                request.nickname(),
                request.avatarUrl()
        );
        if (userResponse.code() != 200) {
            return ApiResponse.fail(userResponse.code(), userResponse.message());
        }

        LoginSession loginSession = loginSessionService.createSession(wxSession, userResponse.data());
        return ApiResponse.success(new WxLoginResponse(
                loginSession.accessToken(),
                loginSession.expiresAt(),
                Boolean.TRUE.equals(userResponse.data().get("registered")),
                false,
                loginSession.user()
        ));
    }

    @Override
    @PostMapping("/silent-login")
    public ApiResponse<WxLoginResponse> silentLogin(@RequestBody WxSilentLoginRequest request) {
        if (request.code() == null || request.code().isBlank()) {
            return ApiResponse.fail(400, "code is required");
        }

        WxSession wxSession = wxMiniProgramClient.code2Session(request.code());
        ApiResponse<Map<String, Object>> userResponse = userServiceClient.findByOpenId(wxSession.openId());
        if (userResponse.code() != 200) {
            return ApiResponse.fail(401, "微信用户未绑定，请先执行一键登录注册");
        }

        LoginSession loginSession = loginSessionService.createSession(wxSession, userResponse.data());
        return ApiResponse.success(new WxLoginResponse(
                loginSession.accessToken(),
                loginSession.expiresAt(),
                false,
                true,
                loginSession.user()
        ));
    }
}
