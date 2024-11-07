package com.programmingtechie.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced // enable Client-Side LoadBalancing in our Eureka clients
    		      // order service make multiple instances of the inventory service
    public WebClient.Builder webClientBuilder() { // is Spring Web Flux project (is not Spring MVC)
        return WebClient.builder();
    }
}
