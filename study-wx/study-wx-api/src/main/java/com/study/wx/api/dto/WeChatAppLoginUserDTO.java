package com.study.wx.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("微信小程序Code授权请求参数")
public class WeChatAppLoginUserDTO {

    @ApiModelProperty(value = "微信授权code", required = true)
    private String code;

    @ApiModelProperty(value = "手机授权code")
    private String mobileCode;


    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
