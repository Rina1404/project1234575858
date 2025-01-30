package com.example.camundaproject;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class CamundaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamundaProjectApplication.class, args);
    }

}
