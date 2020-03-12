package com.rrr.eurekaclientarticleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientArticleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientArticleServiceApplication.class, args);
    }

}
