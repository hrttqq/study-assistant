package com.study.wx.api.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信静默登录请求参数
 *
 * @author gq
 * @date 2022/5/25 10:08
 */
@ApiModel("微信静默登录请求参数")
public class WeChatSilenceLoginDTO {

    @ApiModelProperty(value = "QQ登陆授权code", required = true)
    private String code;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
