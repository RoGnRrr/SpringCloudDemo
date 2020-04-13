package com.rrr.eurekagateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class ResolverConfiguration {

    @Bean(value = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange -> (
            Mono.just(exchange.getRequest().getRemoteAddress().getHostName())
        );
    }

    @Bean(value = "userKeyResolver")
    public KeyResolver userKeyResolver() {
        return exchange -> (
                Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"))
        );
    }

    @Bean(value = "apiKeyResolver")
    public KeyResolver apiKeyResolver() {
        return exchange -> (
                Mono.just(exchange.getRequest().getPath().value())
        );
    }

}
