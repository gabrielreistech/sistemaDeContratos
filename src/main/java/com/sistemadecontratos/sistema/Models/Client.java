package com.sistemadecontratos.sistema.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nome")
    private String name;

    @Column(name = "Descrição")
    private String description;

    @Column(name = "Contratos_Executados")
    private Integer contractsExecuted;

    @Column(name = "Valores_Totais_Em_Contratos")
    private Double valuesInContracts;

    public Client(){}

    public Client(String name, String description) {
        this.name = name;
        this.description = description;
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

