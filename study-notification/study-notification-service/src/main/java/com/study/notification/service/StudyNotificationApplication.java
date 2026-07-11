package com.study.notification.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study")
public class StudyNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyNotificationApplication.class, args);
    }
}
