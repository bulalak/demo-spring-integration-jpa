package com.example.demojpaservice.service;

import com.example.demojpaservice.domain.Document;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.transaction.annotation.Transactional;

@MessagingGateway
public interface EstatementGateway {

    @Transactional
    @Gateway(requestChannel = "estatement.delete-by-id")
    void deleteDocument(Long id);

    @Transactional
    @Gateway(requestChannel = "estatement.add-document")
    Long addDocument(Document document);
}
