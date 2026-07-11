package com.study.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("com.study.user.service.mapper")
@SpringBootApplication(scanBasePackages = "com.study")
public class StudyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUserApplication.class, args);
    }
}
