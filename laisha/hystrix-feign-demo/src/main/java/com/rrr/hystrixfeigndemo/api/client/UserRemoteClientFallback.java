package com.rrr.hystrixfeigndemo.api.client;

import org.springframework.stereotype.Component;

@Component
public class UserRemoteClientFallback implements UserRemoteClient {

    @Override
    public String hello() {
        return "fail";
    }

}
