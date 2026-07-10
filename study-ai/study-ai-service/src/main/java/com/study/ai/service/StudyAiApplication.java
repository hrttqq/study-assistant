package com.study.ai.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study")
public class StudyAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyAiApplication.class, args);
    }
}
