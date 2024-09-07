package com.sistemadecontratos.sistema.Models;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Contratos_Atuais")
public class CurrentContracts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nome", nullable = true)
    private String name;

    @Column(name = "Descrição", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Client client;

    @Column(name = "Preço")
    private Double price;

    @Column(name = "Início_Do_Contrato")
    private LocalDate contractDay;

    @Column(name = "Fim_Do_Contrato")
    private LocalDate contractEnd;

    public CurrentContracts(){}

    public CurrentContracts(ContractsInAgreement contractsInAgreement){
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
