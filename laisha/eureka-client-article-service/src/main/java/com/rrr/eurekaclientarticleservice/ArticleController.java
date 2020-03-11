package com.rrr.eurekaclientarticleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @Autowired
    RestTemplate restTemplate;

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

}
