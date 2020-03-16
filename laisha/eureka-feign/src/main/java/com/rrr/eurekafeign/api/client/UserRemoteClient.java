package com.rrr.eurekafeign.api.client;

import com.rrr.eurekafeign.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client-user-service", configuration = FeignConfiguration.class)
public interface UserRemoteClient {

    @GetMapping("/user/hello")
    String hello();

}
