package com.study.wx.api.inter;

import com.study.common.core.model.ResultMode;
import com.study.wx.api.dto.WeChatAppLoginUserDTO;
import com.study.wx.api.dto.WeChatSilenceLoginDTO;
import com.study.wx.api.vo.WxUserLoginResponseVO;

import java.util.Map;

public interface WxLoginApi {

    /**
     * 探活接口
     *
     * @return
     */
    ResultMode<Map<String, String>> health();

    /**
     * 微信一键登录
     *
     * @param request
     * @return
     */
    ResultMode<WxUserLoginResponseVO> oneClickLogin(WeChatAppLoginUserDTO request);

    /**
     * 微信静默登录
     *
     * @param request
     * @return
     */
    ResultMode<WxUserLoginResponseVO> silentLogin(WeChatSilenceLoginDTO request);
}
