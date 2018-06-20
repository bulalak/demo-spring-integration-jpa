package com.example.demojpaservice.service;

import com.example.demojpaservice.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.dsl.IntegrationFlowAdapter;
import org.springframework.integration.dsl.IntegrationFlowDefinition;
import org.springframework.integration.dsl.jpa.Jpa;
import org.springframework.integration.jpa.support.PersistMode;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class MoveToCezarFlowAdapter extends IntegrationFlowAdapter {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected IntegrationFlowDefinition<?> buildFlow() {
        return from("estatement.move-to-cezar")
                .log("estatement.move-to-cezar")
                .handle(Jpa.updatingGateway(this.entityManagerFactory).persistMode(PersistMode.DELETE))
                .transform(Document::getContractNumber)
                .channel("registry.move.cezar")
                ;
    }
}
