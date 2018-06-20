package com.example.demojpaservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;


@Configuration
public class ClientsIntegration {

    @Bean
    public IntegrationFlow registryMoveToCezar() {
        return IntegrationFlows.from("registry.move.cezar")
                .log("registry.move.cezar", Message::getPayload)
                .handle(System.out::println)
                .get();
    }

}
