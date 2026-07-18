package com.study.wx.api.service;

import com.study.common.core.model.ResultMode;
import com.study.wx.api.dto.WeChatAppLoginUserDTO;
import com.study.wx.api.dto.WeChatSilenceLoginDTO;
import com.study.wx.api.vo.WxUserLoginResponseVO;

public interface WxLoginService {

    ResultMode<WxUserLoginResponseVO> waChatAppleLogin(WeChatAppLoginUserDTO request);

    ResultMode<WxUserLoginResponseVO> silentLogin(WeChatSilenceLoginDTO request)
}
