package com.study.file.api.dto;

public record MaterialUploadRequest(String fileName, String fileType, Long size, String url) {
}
