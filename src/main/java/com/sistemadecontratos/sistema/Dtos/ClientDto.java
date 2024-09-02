package com.sistemadecontratos.sistema.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class ClientDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private Integer contractsExecuted;

    private Double valuesInContracts;

    public ClientDto(){}

    public ClientDto(String name, String description) {
        this.name = name;
        this.description = description;
        this.contractsExecuted = 0;
        this.valuesInContracts = 0.0;
    }

    public ClientDto(String name, String description, Integer contractsExecuted) {
        this.name = name;
        this.description = description;
        this.contractsExecuted = contractsExecuted;
    }

    public ClientDto(String name, String description, Integer contractsExecuted, Double valuesInContracts) {
        this.name = name;
        this.description = description;
        this.contractsExecuted = contractsExecuted;
        this.valuesInContracts = valuesInContracts;
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

    public Integer getContractsExecuted() {
        return contractsExecuted;
    }

    public void setContractsExecuted(Integer contractsExecuted) {
        this.contractsExecuted = contractsExecuted;
    }

    public Double getValuesInContracts() {
        return valuesInContracts;
    }

    public void setValuesInContracts(Double valuesInContracts) {
        this.valuesInContracts = valuesInContracts;
    }
}
