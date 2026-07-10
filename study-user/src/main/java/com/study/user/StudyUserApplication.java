package com.study.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study")
public class StudyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUserApplication.class, args);
    }
}
