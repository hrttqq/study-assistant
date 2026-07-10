package com.study.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study")
public class StudyAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyAuthApplication.class, args);
    }
}
