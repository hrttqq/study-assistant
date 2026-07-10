package com.study.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study")
public class StudyGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyGatewayApplication.class, args);
    }
}
