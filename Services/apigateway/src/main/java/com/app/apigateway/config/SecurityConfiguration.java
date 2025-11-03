package com.app.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {

    @Bean
    public RouteLocator customRouted(RouteLocatorBuilder builder){
        return builder.routes()
                .route("user-service", r -> r.path("/api/user/**")
                        .uri("lb://USER-SERVICE"))
                .route("email-service", r -> r.path("/api/email/**")
                        .uri("lb://EMAIL-SERVICE"))
                .route("internship-service",r -> r.path("/intership/**")
                        .uri("lb://INTERNSHIP-SERVICE"))
                .route("mentor-service", r -> r.path("/api/mentor/**")
                        .uri("lb://MENTOR-SERVICE"))
                .build();

    }
}
