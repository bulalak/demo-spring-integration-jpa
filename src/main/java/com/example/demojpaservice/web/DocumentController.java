package com.example.demojpaservice.web;

import com.example.demojpaservice.service.EstatementGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {

    @Autowired
    public EstatementGateway estatementGateway;

    @RequestMapping(value = "/documents/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDocument(@PathVariable("id") Long id) {
        estatementGateway.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
}
