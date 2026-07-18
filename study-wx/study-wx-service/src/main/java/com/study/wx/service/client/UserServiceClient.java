package com.study.wx.service.client;

import com.study.common.core.ApiResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.study.wx.service.config.WxMiniProgramProperties;

import java.util.Map;

@Component
public class UserServiceClient {

    private final RestClient restClient;
    private final WxMiniProgramProperties properties;

    public UserServiceClient(RestClient.Builder restClientBuilder, WxMiniProgramProperties properties) {
        this.restClient = restClientBuilder.build();
        this.properties = properties;
    }

    public ApiResponse<Map<String, Object>> findByOpenId(String openId) {
        return restClient.get()
                .uri(properties.getUserServiceUrl() + "/users/internal/wx/openid/{openId}", openId)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public ApiResponse<Map<String, Object>> registerOrLogin(String openId, String unionId, String nickname, String avatarUrl) {
        Map<String, Object> body = Map.of(
                "openId", openId,
                "unionId", unionId == null ? "" : unionId,
                "nickname", nickname == null ? "" : nickname,
                "avatarUrl", avatarUrl == null ? "" : avatarUrl
        );
        return restClient.post()
                .uri(properties.getUserServiceUrl() + "/users/internal/wx/register-or-login")
                .body(body)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
