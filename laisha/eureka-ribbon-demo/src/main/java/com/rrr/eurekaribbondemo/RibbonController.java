package com.rrr.eurekaribbondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon/test")
    @ResponseBody
    public String ribbonTest(){
        String s = restTemplate.getForObject("http://eureka-client-user-service/user/hello", String.class);
        s += "/ribbon/test";
        return s;
    }

    //
}
