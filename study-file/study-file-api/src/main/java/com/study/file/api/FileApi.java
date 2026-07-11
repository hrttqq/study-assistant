package com.study.file.api;

import com.study.common.core.ApiResponse;
import com.study.file.api.dto.MaterialUploadRequest;

import java.util.List;
import java.util.Map;

public interface FileApi {

    ApiResponse<Map<String, String>> health();

    ApiResponse<Map<String, Object>> upload(MaterialUploadRequest request);

    ApiResponse<List<Map<String, Object>>> listMaterials();

    ApiResponse<Map<String, Object>> analyze(Long materialId);
}
