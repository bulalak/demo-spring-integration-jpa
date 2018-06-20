package com.example.demojpaservice.service;

import com.example.demojpaservice.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.dsl.IntegrationFlowAdapter;
import org.springframework.integration.dsl.IntegrationFlowDefinition;
import org.springframework.integration.dsl.jpa.Jpa;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class AddDocumentFlowAdapter extends IntegrationFlowAdapter {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected IntegrationFlowDefinition<?> buildFlow() {
        return from("estatement.add-document")
                .log("estatement.add-document")
                .handle(Jpa.updatingGateway(this.entityManagerFactory))
                .transform(Document::getId)
                ;
    }
}
