package com.rrr.eurekaclientuserservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @ResponseBody
    @GetMapping("user/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

}
