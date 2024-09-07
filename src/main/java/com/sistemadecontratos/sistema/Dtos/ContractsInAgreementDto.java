package com.sistemadecontratos.sistema.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ContractsInAgreementDto {

    @NotBlank(message = "Nome do contrato é obrigatório.")
    private String name;

    @NotBlank(message = "Nome da descrição é obrigatório.")
    private String description;

    @NotNull(message = "Informar o ID do cliente é obrigatório.")
    private Long client;

    private Double price;

    private LocalDate contractDay;

    private LocalDate contractEnd;

    ContractsInAgreementDto(){}

    public ContractsInAgreementDto(String name, String description, Long client) {
        this.name = name;
        this.description = description;
        this.client = client;
    }

    public ContractsInAgreementDto(String name, String description, Long client, Double price, LocalDate contractDay, LocalDate contractEnd) {
        this.name = name;
        this.description = description;
        this.client = client;
        this.price = price;
        this.contractDay = contractDay;
        this.contractEnd = contractEnd;
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

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
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
