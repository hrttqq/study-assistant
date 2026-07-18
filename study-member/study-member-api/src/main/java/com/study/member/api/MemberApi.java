package com.study.member.api;

import com.study.member.api.dto.UpgradeRequest;

import java.util.List;
import java.util.Map;

public interface MemberApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<List<Map<String, Object>>> listPlans();

    ApiResponse<Map<String, Object>> currentMembership();

    ApiResponse<Map<String, Object>> upgrade(UpgradeRequest request);
}
