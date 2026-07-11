package com.study.member.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.study")
public class StudyMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyMemberApplication.class, args);
    }
}
