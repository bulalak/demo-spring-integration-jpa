package com.example.demojpaservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Document {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 15, nullable = false)
    private String contractNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", contractNumber='" + contractNumber + '\'' +
                '}';
    }
}
