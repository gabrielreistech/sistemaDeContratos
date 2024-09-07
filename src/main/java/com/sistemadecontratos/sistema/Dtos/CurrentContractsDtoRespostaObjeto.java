package com.sistemadecontratos.sistema.Dtos;

import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Models.CurrentContracts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CurrentContractsDtoRespostaObjeto {

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
    private LocalDate contractDay;

    @NotNull
    private LocalDate contractEnd;

    public CurrentContractsDtoRespostaObjeto(){}

    public CurrentContractsDtoRespostaObjeto(CurrentContracts currentContracts){
        id = currentContracts.getId();
        name = currentContracts.getName();
        description = currentContracts.getDescription();
        client = currentContracts.getClient();
        price = currentContracts.getPrice();
        contractDay = currentContracts.getContractDay();
        contractDay = currentContracts.getContractDay();
    }

    public @NotNull Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public @NotNull Client getClient() {
        return client;
    }

    public void setClient(@NotNull Client client) {
        this.client = client;
    }

    public @NotNull Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull Double price) {
        this.price = price;
    }

    public @NotNull LocalDate getContractDay() {
        return contractDay;
    }

    public void setContractDay(@NotNull LocalDate contractDay) {
        this.contractDay = contractDay;
    }

    public @NotNull LocalDate getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(@NotNull LocalDate contractEnd) {
        this.contractEnd = contractEnd;
    }
}
