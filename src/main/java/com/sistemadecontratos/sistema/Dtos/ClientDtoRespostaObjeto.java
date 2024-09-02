package com.sistemadecontratos.sistema.Dtos;

import com.sistemadecontratos.sistema.Models.Client;
import jakarta.persistence.Column;

public class ClientDtoRespostaObjeto {

    private Long id;

    private String name;

    private String description;

    private Integer contractsExecuted;

    private Double valuesInContracts;

    public ClientDtoRespostaObjeto(Client client){
        id = client.getId();
        name = client.getName();
        description = client.getDescription();
        contractsExecuted = client.getContractsExecuted();
        valuesInContracts = client.getValuesInContracts();
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
