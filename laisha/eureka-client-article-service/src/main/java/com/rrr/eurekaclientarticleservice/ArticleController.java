package com.rrr.eurekaclientarticleservice;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/article/callHello")
    @ResponseBody
    public String callHello() {
        return restTemplate.getForObject("http://localhost:8081/user/hello", String.class);
    }

    @GetMapping("/article/callHello2")
    @ResponseBody
    public String callHello2() {
        return restTemplate.getForObject("http://eureka-client-user-service/user/hello", String.class);
    }

    @GetMapping("/article/infos")
    @ResponseBody
    public Object infos() {
        // return eurekaClient.getInstancesByVipAddress("eureka-client-user-service", false);
        return discoveryClient.getInstances("eureka-client-user-service");
    }

}
