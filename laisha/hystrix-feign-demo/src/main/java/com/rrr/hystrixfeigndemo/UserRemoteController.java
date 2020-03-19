package com.rrr.hystrixfeigndemo;

import com.rrr.hystrixfeigndemo.api.client.UserRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserRemoteController {

    @Autowired
    UserRemoteClient userRemoteClient;

    @ResponseBody
    @GetMapping("/callHello")
    public String callHello() {
        return userRemoteClient.hello();
    }


}
