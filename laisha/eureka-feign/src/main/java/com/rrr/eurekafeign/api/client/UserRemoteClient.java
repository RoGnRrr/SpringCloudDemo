package com.rrr.eurekafeign.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client-user-service")
public interface UserRemoteClient {

    @GetMapping("/user/hello")
    String hello();

}
