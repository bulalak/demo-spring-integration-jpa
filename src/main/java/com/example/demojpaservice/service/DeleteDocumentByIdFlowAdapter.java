package com.example.demojpaservice.service;

import com.example.demojpaservice.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.dsl.IntegrationFlowAdapter;
import org.springframework.integration.dsl.IntegrationFlowDefinition;
import org.springframework.integration.dsl.jpa.Jpa;
import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class DeleteDocumentByIdFlowAdapter extends IntegrationFlowAdapter {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private AbstractRequestHandlerAdvice exceptionProviderAdvice;

    @Override
    protected IntegrationFlowDefinition<?> buildFlow() {
        return from("estatement.delete-by-id")
                .log("estatement.delete-by-id")
                .handle(Jpa.retrievingGateway(this.entityManagerFactory).entityClass(Document.class).idExpression("payload"), c -> c.advice(exceptionProviderAdvice))
                .channel("estatement.move-to-cezar")
                ;
    }
}
