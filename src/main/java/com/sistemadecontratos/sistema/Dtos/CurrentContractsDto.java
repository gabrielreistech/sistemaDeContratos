package com.sistemadecontratos.sistema.Dtos;

import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Models.ModelsContracts.CurrentContracts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CurrentContractsDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Client client;

    @NotNull
    private Double price;

    @NotNull
    private LocalDateTime contractDay;

    @NotNull
    private LocalDateTime contractEnd;

    public CurrentContractsDto(CurrentContracts currentContracts){
        id = currentContracts.getId();
        name = currentContracts.getName();
        description = currentContracts.getDescription();
        client = currentContracts.getClient();
        price = currentContracts.getPrice();
        contractDay = currentContracts.getContractDay();
        contractEnd = currentContracts.getContractEnd();
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

    public LocalDateTime getContractDay() {
        return contractDay;
    }

    public void setContractDay(LocalDateTime contractDay) {
        this.contractDay = contractDay;
    }

    public LocalDateTime getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDateTime contractEnd) {
        this.contractEnd = contractEnd;
    }
}
