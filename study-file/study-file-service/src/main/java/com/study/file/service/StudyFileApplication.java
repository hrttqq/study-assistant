package com.study.file.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study")
public class StudyFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyFileApplication.class, args);
    }
}
