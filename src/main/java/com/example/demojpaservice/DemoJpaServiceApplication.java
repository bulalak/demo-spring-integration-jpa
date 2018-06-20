package com.example.demojpaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class DemoJpaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaServiceApplication.class, args);
    }
}
