package com.example.tdd_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TddStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddStudyApplication.class, args);
    }

}
