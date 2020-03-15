package com.rrr.eurekaribbondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "eureka-client-user-service",configuration = MyRule.class)
public class EurekaRibbonDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonDemoApplication.class, args);
    }

}
