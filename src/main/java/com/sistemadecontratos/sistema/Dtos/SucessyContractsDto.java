package com.sistemadecontratos.sistema.Dtos;

import com.sistemadecontratos.sistema.Models.SucessyContracts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SucessyContractsDto {

    @NotBlank(message = "Nome do contrato é obrigatório.")
    private String name;

    @NotBlank(message = "Nome da descrição é obrigatório.")
    private String description;

    @NotNull(message = "Informar o ID do cliente é obrigatório.")
    private Long client;

    private Double price;

    private LocalDate contractDay;

    private LocalDate contractEnd;

    SucessyContractsDto(){}

    public SucessyContractsDto(String name, String description, Long client, Double price, LocalDate contractDay, LocalDate contractEnd) {
        this.name = name;
        this.description = description;
        this.client = client;
        this.price = price;
        this.contractDay = contractDay;
        this.contractEnd = contractEnd;
    }

    public SucessyContractsDto(SucessyContracts sucessyContracts) {
        name = sucessyContracts.getName();
        description = sucessyContracts.getDescription();
        client = sucessyContracts.getClient().getId();
        price = sucessyContracts.getPrice();
        contractDay = sucessyContracts.getContractDay();
        contractEnd = sucessyContracts.getContractEnd();
    }

    public @NotBlank(message = "Nome do contrato é obrigatório.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Nome do contrato é obrigatório.") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Nome da descrição é obrigatório.") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Nome da descrição é obrigatório.") String description) {
        this.description = description;
    }

    public @NotNull(message = "Informar o ID do cliente é obrigatório.") Long getClient() {
        return client;
    }

    public void setClient(@NotNull(message = "Informar o ID do cliente é obrigatório.") Long client) {
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
