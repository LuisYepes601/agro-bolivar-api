package com.nexus.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AgroBolivarApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgroBolivarApplication.class, args);
    }

}
