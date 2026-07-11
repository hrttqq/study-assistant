package com.study.plan.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study")
public class StudyPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyPlanApplication.class, args);
    }
}
