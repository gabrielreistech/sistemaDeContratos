package com.sistemadecontratos.sistema.Dtos;

import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Models.SucessyContracts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SucessyContractsDtoRespostaObjeto {

    private Long id;

    @NotBlank(message = "Nome do contrato é obrigatório.")
    private String name;

    @NotBlank(message = "Nome da descrição é obrigatório.")
    private String description;

    @NotNull(message = "Informar o ID do cliente é obrigatório.")
    private Client client;

    private Double price;

    private LocalDate contractDay;

    private LocalDate contractEnd;

    public SucessyContractsDtoRespostaObjeto(){}

    public SucessyContractsDtoRespostaObjeto(String name, String description, Client client, Double price, LocalDate contractDay, LocalDate contractEnd) {
        this.name = name;
        this.description = description;
        this.client = client;
        this.price = price;
        this.contractDay = contractDay;
        this.contractEnd = contractEnd;
    }

    public SucessyContractsDtoRespostaObjeto(SucessyContracts sucessyContracts){
        this.id = sucessyContracts.getId();
        this.name = sucessyContracts.getName();
        this.client = sucessyContracts.getClient();
        this.price = sucessyContracts.getPrice();
        this.contractDay = sucessyContracts.getContractDay();
        this.contractEnd = sucessyContracts.getContractEnd();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public @NotNull(message = "Informar o ID do cliente é obrigatório.") Client getClient() {
        return client;
    }

    public void setClient(@NotNull(message = "Informar o ID do cliente é obrigatório.") Client client) {
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
