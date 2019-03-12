package com.jack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppHystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppHystrixDashboardApplication.class, args);
    }
}
