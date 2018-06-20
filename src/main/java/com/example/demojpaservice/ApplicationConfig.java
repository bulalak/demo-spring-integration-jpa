package com.example.demojpaservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.integration.handler.advice.ExpressionEvaluatingRequestHandlerAdvice;
import org.springframework.messaging.Message;

import javax.persistence.EntityNotFoundException;

@Configuration
public class ApplicationConfig {

    @Bean
    public AbstractRequestHandlerAdvice exceptionProviderAdvice() {
        return new ExpressionEvaluatingRequestHandlerAdvice() {
            @Override
            protected Object doInvoke(ExecutionCallback callback, Object target, Message<?> message) throws Exception {
                Object result = super.doInvoke(callback, target, message);
                if (result == null) {
                    throw new EntityNotFoundException("Entity not found.");
                }
                return result;
            }
        };
    }

//    @Bean
//    public CommandLineRunner runner(EstatementGateway estatementGateway) {
//        return x -> {
//            Document document = new Document();
//            document.setContractNumber("1122334455");
//            estatementGateway.addDocument(document);
//        };
//    }

}
