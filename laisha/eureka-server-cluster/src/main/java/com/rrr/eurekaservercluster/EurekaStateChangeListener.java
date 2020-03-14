package com.rrr.eurekaservercluster;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaServerStartedEvent eurekaServerStartedEvent) {
        System.out.println("Eureka Server 启动.");
    }

}
