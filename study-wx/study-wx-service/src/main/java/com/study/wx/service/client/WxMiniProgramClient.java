package com.study.wx.service.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.study.wx.service.config.WxMiniProgramProperties;
import com.study.wx.service.domain.WxSession;

@Component
public class WxMiniProgramClient {

    private static final String AUTHORIZATION_CODE = "authorization_code";

    private final RestClient restClient;
    private final WxMiniProgramProperties properties;

    public WxMiniProgramClient(RestClient.Builder restClientBuilder, WxMiniProgramProperties properties) {
        this.restClient = restClientBuilder.build();
        this.properties = properties;
    }

    public WxSession code2Session(String code) {
        if (Boolean.TRUE.equals(properties.getMockEnabled())) {
            String suffix = Integer.toHexString(Math.abs(code.hashCode()));
            return new WxSession("mock-openid-" + suffix, "mock-session-key-" + suffix, "mock-unionid-" + suffix);
        }

        String uri = UriComponentsBuilder.fromUriString(properties.getCode2SessionUrl())
                .queryParam("appid", properties.getAppId())
                .queryParam("secret", properties.getAppSecret())
                .queryParam("js_code", code)
                .queryParam("grant_type", AUTHORIZATION_CODE)
                .toUriString();

        WxCode2SessionResponse response = restClient.get()
                .uri(uri)
                .retrieve()
                .body(WxCode2SessionResponse.class);

        if (response == null || response.openId() == null || response.openId().isBlank()) {
            String message = response == null ? "empty wx response" : response.errorMessage();
            throw new IllegalStateException("微信 code2session 失败: " + message);
        }
        return new WxSession(response.openId(), response.sessionKey(), response.unionId());
    }

    private record WxCode2SessionResponse(
            @JsonProperty("openid") String openId,
            @JsonProperty("session_key") String sessionKey,
            @JsonProperty("unionid") String unionId,
            @JsonProperty("errcode") Integer errorCode,
            @JsonProperty("errmsg") String errorMessage
    ) {
    }
}
