package com.demomicro.categorieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CategorieServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategorieServiceApplication.class, args);
    }
}
