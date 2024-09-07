package com.sistemadecontratos.sistema.Dtos;

import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Models.ContractsInAgreement;

import java.time.LocalDate;

public class ContractsInAgreementDtoRespostaObjeto {

    private Long id;

    private String name;

    private String description;

    private Client client;

    private Double price;

    private LocalDate contractDay;

    private LocalDate contractEnd;

    public ContractsInAgreementDtoRespostaObjeto(ContractsInAgreement contractsInAgreement){
        id = contractsInAgreement.getId();
        name = contractsInAgreement.getName();
        description = contractsInAgreement.getDescription();
        client = contractsInAgreement.getClient();
        price = contractsInAgreement.getPrice();
        contractDay = contractsInAgreement.getContractDay();
        contractEnd = contractsInAgreement.getContractEnd();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getContractDay() {
        return contractDay;
    }

    public void setContractDay(LocalDate contractDay) {
        this.contractDay = contractDay;
    }

    public LocalDate getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDate contractEnd) {
        this.contractEnd = contractEnd;
    }
}
